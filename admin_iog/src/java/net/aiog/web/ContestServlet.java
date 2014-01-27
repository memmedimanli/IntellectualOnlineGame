
package net.aiog.web;

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
import net.aiog.database.ContestDao;
import net.aiog.database.DatabaseUtility;
import net.aiog.database.MySqlContestDao;
import net.aiog.domain.Contest;
import net.aiog.service.ContestService;
import net.aiog.service.DefaultContestService;

/**
 *
 * @author memmedimanli
 */
public class ContestServlet extends HttpServlet {
    
    private Contest readContest(HttpServletRequest request)
    {
        Contest contest = new Contest();
        
        if(request.getParameter("contestName") != null)
        {
            contest.setContestName(request.getParameter("contestName").trim());
        }
        
         if(request.getParameter("date") != null)
        {
            contest.setContestDate(request.getParameter("date").trim());
        }
        
          if(request.getParameter("time") != null)
        {
            contest.setBeginTime(request.getParameter("time").trim());
        }
          
          return contest;
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
             DataSource ds = DatabaseUtility.connect();
             ContestDao contestDao = new MySqlContestDao(ds);        
             ContestService contestService = new DefaultContestService(contestDao);
             
             HttpSession session = request.getSession();
             String action = "";
             
             if (request.getParameter("action") != null) {
                action = request.getParameter("action").trim();
            }
             
             if(action.equals("contest"))
             {
                 Contest contest = readContest(request);
                 
                  Map<String, List<String>> errors = ValidationUtility.validateCreateContest(contest);
                  
                  boolean isValid = true;

                for (String key : errors.keySet()) {
                    List<String> validationErrors = errors.get(key);
                    if (!validationErrors.isEmpty()) {
                        isValid = false;
                        break;
                    }
                }
                
                if (isValid) {
                    boolean success = contestService.createContest(contest);
                    String creatingResult = "";

                    if (success) {
                        creatingResult = "Contest are created successfully.";
                    } else {
                        creatingResult = "Contest are not created.";
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("message", creatingResult);
                    rd.forward(request, response);
                } else {
                    session.setAttribute("creatingContestError", errors);
                    response.sendRedirect("contest.jsp");
                }
        
                                  
             }else{
                 out.println("ERROR");
             }
           
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ContestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ContestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
