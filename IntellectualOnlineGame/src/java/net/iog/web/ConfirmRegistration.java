/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.iog.database.MySqlConfirmDao;

/**
 *
 * @author memmedimanli
 */
public class ConfirmRegistration extends HttpServlet {

    private static final long serialVersionUID = 1L;

  /*  private static Map<String, String> getQueryParams(String query) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            if (query.length() > 1) {
                for (String param : query.split("&")) {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }
                    params.put(key, value);
                }
            }

            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }
*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        System.out.println(request.getQueryString());
      //  Map<String, String> paramMap = ConfirmRegistration.getQueryParams(request.getQueryString());
       // boolean confirmSuccess = MySqlConfirmDao.confirm(paramMap);
        
        String username= request.getParameter("username");
        String email = request.getParameter("email");
        System.out.println("Username = " + username);
        System.out.println("Email = " + email);
        boolean confirmSuccess = MySqlConfirmDao.confirm(username, email);
        
        HttpSession session = request.getSession();
        session.setAttribute("user", username);
        session.setAttribute("email",email);

        

        try {
            if (confirmSuccess) {
                response.sendRedirect("registrationConfirmation.jsp");
            } else {
                System.out.println("Regisrtation Confirmation Failed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
