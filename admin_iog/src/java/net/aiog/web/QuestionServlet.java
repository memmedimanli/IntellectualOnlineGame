/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import net.aiog.database.DatabaseUtility;
import net.aiog.database.MySqlQuestionDao;
import net.aiog.database.QuestionDao;
import net.aiog.domain.Question;
import net.aiog.service.DefaultQuestionService;
import net.aiog.service.QuestionService;

/**
 *
 * @author memmedimanli
 */
public class QuestionServlet extends HttpServlet {

    private Question readQuestions(HttpServletRequest request) {
        Question question = new Question();

        if (request.getParameter("content") != null) {
            question.setContent(request.getParameter("content").trim());
        }

        if (request.getParameter("answer") != null) {
            question.setAnswer(request.getParameter("answer").trim());
        }

        if (request.getParameter("author") != null) {
            question.setAuthor(request.getParameter("author").trim());
        }

        if (request.getParameter("comment") != null) {
            question.setComment(request.getParameter("comment").trim());
        }
        
         if (request.getParameter("game_id") != null) {
            question.setGame_id(request.getParameter("game_id").trim());
        }

        return question;

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();




        try {

            DataSource ds = DatabaseUtility.connect();
            QuestionDao questionDao = new MySqlQuestionDao(ds);
            QuestionService questionService = new DefaultQuestionService(questionDao);

            HttpSession session = request.getSession();
            String action = "";

            if (request.getParameter("action") != null) {
                action = request.getParameter("action").trim();
            }

            if (action.equals("question")) {

                Question question = readQuestions(request);

                Map<String, List<String>> errors = ValidationUtility.validateAddQuestion(question);


                boolean isValid = true;

                for (String key : errors.keySet()) {
                    List<String> validationErrors = errors.get(key);
                    if (!validationErrors.isEmpty()) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    boolean success = questionService.add_question(question);
                    String addingResult = "";

                    if (success) {
                        addingResult = "Questions are added successfully";
                    } else {
                        addingResult = "Questions isn`t added.";
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("message", addingResult);
                    rd.forward(request, response);
                } else {
                    session.setAttribute("addQuestionErrors", errors);
                    response.sendRedirect("question.jsp");
                }
            }else
            {
                 out.println("salam sehvin var qaqas.");
            }

        }catch (Exception e) {
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
            Logger.getLogger(QuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(QuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
