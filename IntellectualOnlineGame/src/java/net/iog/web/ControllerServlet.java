package net.iog.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.iog.database.DatabaseUtility;
import net.iog.database.MySqlRegistrationDao;
import net.iog.database.RegistrationDao;
import net.iog.domain.RegisterEmail;
import net.iog.domain.RegistrationForm;
import net.iog.service.DefaultRegistrationService;
import net.iog.service.RegistrationService;

/**
 *
 * @author memmedimanli
 */
public class ControllerServlet extends HttpServlet {

    private RegistrationForm readRegistrationData(HttpServletRequest request) {
        RegistrationForm form = new RegistrationForm();

        if (request.getParameter("username") != null) {
            form.setUsername(request.getParameter("username").trim());
        }

        if (request.getParameter("name") != null) {
            form.setName(request.getParameter("name").trim());
        }

        if (request.getParameter("surname") != null) {
            form.setSurname(request.getParameter("surname").trim());
        }

        if (request.getParameter("email") != null) {
            form.setEmail(request.getParameter("email").trim());
        }

        if (request.getParameter("password") != null) {
            form.setPassword(request.getParameter("password").trim());
        }

        if (request.getParameter("passwordConfirmation") != null) {
            form.setPasswordConfirmation(request.getParameter("passwordConfirmation").trim());
        }



        return form;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            DataSource ds = DatabaseUtility.connect();
            RegistrationDao registrationDao = new MySqlRegistrationDao(ds);
            RegistrationService registrationService = new DefaultRegistrationService(registrationDao);


            HttpSession session = request.getSession();
            String action = "";
            
            if (request.getParameter("action") != null) {
                action = request.getParameter("action").trim();
            }

            if (action.equals("register")) {
            
                RegistrationForm form = readRegistrationData(request);

                Map<String, List<String>> errors = ValidationUtility.validateRegistrationForm(form);

                if (!registrationService.isUniqueUsername(form.getUsername())) {
                    errors.get("username").add("Username must be unique");
                }

                boolean isValidForm = true;

                for (String key : errors.keySet()) {
                    List<String> validationErrors = errors.get(key);
                    if (!validationErrors.isEmpty()) {
                        isValidForm = false;
                        break;
                    }
                }

                
                if (isValidForm) {
                    
                    boolean success = registrationService.register(form);
                    String registrationResult = "";
                    if (success) {
                        
                        System.out.println("Need to send the confirmation mail to the Email");
                        RegisterEmail mail = new RegisterEmail();
                        System.out.println("Sending Registration mail");
                        mail.sendRegistrationEmail(form);
                        registrationResult = "You've successfully registered";
                    } else {
                        registrationResult = "Your registration failed. Please try again or contact support";
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("message", registrationResult);
                    rd.forward(request, response);

                } else {
                   
                    session.setAttribute("registrationErrors", errors);
                    session.setAttribute("registrationForm", form);              
                    response.sendRedirect("register.jsp");

                }

            } else {
                out.println("salam sehvin var qaqas.");
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
