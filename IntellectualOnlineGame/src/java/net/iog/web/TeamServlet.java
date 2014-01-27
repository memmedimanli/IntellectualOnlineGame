package net.iog.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.iog.database.DatabaseUtility;
import net.iog.database.MySqlTeamDao;
import net.iog.database.TeamDao;
import net.iog.domain.TeamRegistration;
import net.iog.service.DefaultTeamService;
import net.iog.service.TeamService;

/**
 *
 * @author memmedimanli
 */
public class TeamServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String teamName = request.getParameter("teamname");

            TeamRegistration team = new TeamRegistration();
            team.setTeamName(teamName);

            if (teamName != null && teamName.trim().length() > 0) {
                teamName = teamName.trim();

                DataSource ds = DatabaseUtility.connect();
                TeamDao teamDao = new MySqlTeamDao(ds);
                TeamService teamService = new DefaultTeamService(teamDao);

                HttpSession session = request.getSession();

                String action = "";

                if (request.getParameter("action") != null) {
                    action = request.getParameter("action").trim();
                }

                if (action.equals("t_register")) {
                    Map<String, List<String>> errors = ValidationUtility.validateTeamRegistration(team);

                    if (!teamService.isUniqueTeamName(team.getTeamName())) {
                        errors.get("teamName").add("Team name must be unique");
                    }

                    boolean isValid = true;

                    for (String key : errors.keySet()) {
                        List<String> validationErrors = errors.get(key);
                        if (!validationErrors.isEmpty()) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        boolean success = teamService.registerTeam(team);
                        String teamRegistrationResult = "";

                        if (success) {
                            teamRegistrationResult = "You've successfully registered";
                        } else {
                            teamRegistrationResult = "Your registration failed. Please try again or contact support";
                        }

                        RequestDispatcher rd = request.getRequestDispatcher("invite.jsp");
                        request.setAttribute("message", teamRegistrationResult);
                        rd.forward(request, response);

                    }else{
                    session.setAttribute("teamRegistrationErrors", errors);
                    session.setAttribute("teamRegistration", team);
//                    response.sendRedirect("register.jsp");
                    response.sendRedirect("team.jsp");
                    }

                }else {
                out.println("salam sehvin var qaqas.");
            }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TeamServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TeamServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
