package net.iog.web;

import java.io.IOException;
import java.io.PrintWriter;
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
import net.iog.database.ForumDao;
import net.iog.database.MySqlForumDao;
import net.iog.domain.Forum;
import net.iog.service.DefaultForumService;
import net.iog.service.ForumService;

/**
 *
 * @author memmedimanli
 */
public class AddForumServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String subject = request.getParameter("subject");
            String content = request.getParameter("content");

            Forum forum = new Forum();
            if (subject != null && subject.trim().length() > 0) {
                forum.setTitle("subject");
            }
            if (content != null && subject.trim().length() > 0) {
                forum.setContent("content");
            }

            DataSource ds = DatabaseUtility.connect();
            ForumDao forumDao = new MySqlForumDao(ds);
            ForumService forumService = new DefaultForumService(forumDao);

            HttpSession session = request.getSession();

            String action = "";

            if (request.getParameter("action") != null) {
                action = request.getParameter("action").trim();
            }

            if (action.equals("addForum")) {
                boolean isValid = true;

                if (isValid) {
                    boolean success = forumService.posted(forum);
                    String addForumResult = "";

                    if (success) {
                        addForumResult = "Your post added successfully.";
                    } else {
                        addForumResult = "Your post is not added.";
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("forum.jsp");
                    request.setAttribute("message", addForumResult);
                    rd.forward(request, response);

                } else {

                    session.setAttribute("addForum", forum);
                    System.out.println("sehv burdadir.");
//                    response.sendRedirect("register.jsp");
                    response.sendRedirect("add_forum.jsp");
                }
            } else {
                out.println("sehvin var ibrat -_-.");
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
        } catch (Exception ex) {
            Logger.getLogger(AddForumServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddForumServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
