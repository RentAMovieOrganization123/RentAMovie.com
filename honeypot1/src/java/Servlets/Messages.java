/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Repositories;
import Model.Reaction;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tom.watteny
 */
@WebServlet(name = "Messages", urlPatterns = {"/Messages.php"})
public class Messages extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        int param = 0;
        response.setContentType("text/html;charset=UTF-8");
        try {
            param = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            request.getSession().setAttribute("messageToUserRegister", "Please dont mess with the request!");
            try {
                response.sendRedirect("forum.php");
            } catch (IOException ex) {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Subject s = Repositories.getSubjectRepository().getSubjectByID(param);
        List<Reaction> reactions = new ArrayList();

        if (s == null) {
            request.getSession().setAttribute("messageToUserRegister", "Please dont mess with the request!");
            try {
                response.sendRedirect("forum.php");
            } catch (IOException ex) {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        request.getSession().setAttribute("subject", s);
        reactions = s.getReactions();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='assets/css/template.css'/>");
            out.println("<link rel='stylesheet' href='assets/css/messages.css' />");
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/javascript.js\" ></script>");
            out.println("<script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>");
            out.println("<title>Messages</title>");
            out.println("</head>");
            out.println("<body>");
            //header
            out.println("<header>");
            out.println("<nav>");
            out.println("<li><a href='index.php'>Home</a></li>");
            out.println("<li><a href='forum.php'>Forum</a></li>");
            out.println("<li><a href='register.php'>Register</a></li>");
            out.println("<li><a href='profile.php'>Profile</a></li>");
            out.println("<li><a href='logout.php'>Logout</a></li>");
            out.println("</nav>");
            out.println("</header>");
            //end header

            //content
            out.println("<content>");

            out.println("<h1>Forum post</h1>");
            out.println("<form action='cbehindCreateMessage.php' method='post'>");
            out.println("<table id='sender'>");
            out.println("<tbody>");

            out.println("<tr>");
            out.println("<td><label>Subject: </label></td>");
            out.println("<td><label>" + s.getName() + "</label></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><label>Created by: </label></td>");
            out.println("<td><label>" + s.getContentOwner().getUserName() + "</label></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><label>Date created post: </label></td>");
            out.println("<td><label>" + s.getDateOfCreation() + "</label></td>");
            out.println("</tr>");

            out.println("</tbody>");
            out.println("</table>");

            out.println("<table id='messages'>");
            out.println("<tbody>");

            for (Reaction r : reactions) {
                out.println("<tr>");
                out.println("<td><label> Message by: " + r.getContentOwner().getUserName() + "</label></td>");
                out.println("<td><label>" + r.getContent() + "</label></td>");
                out.println("</tr>");
            }
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");

            //INPUT POST A MESSAGE
            out.println("<tr id='diffrentiate'>");

            out.println("<td><label>Post a message: </label></td>");
            out.println("<td><textarea rows='10' cols='30' required name='message' id='input'> </textarea></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td height='45px' colspan='2'><input type='submit' id='submit' value='post a message'/></td>");
            out.println("</tr>");

            out.println("</tbody>");
            out.println("</table>");
            out.println("</form>");
            //captcha
            out.println("<div class='g-recaptcha' data-sitekey='6LcciDUUAAAAAMs0rvPs5jg-oKg40t9_yBz3RRxJ'></div>");

            out.println("</content>");
            //end content

            //footer
            out.println("<footer>");
            out.println("<a href='http://www.howest.be'><img></a>");
            out.println("<p>Heb je problemen? <a href='support.php' id='contact'>Contacteer ons!</a> </p>");
            out.println("<p>Hogeschool Howest Brugge - Honeypot project </p>");
            out.println("</footer>");
            //end footer

            out.println("</html>");

        } catch (IOException ex) {
            try {
                request.getSession().setAttribute("messageToUserRegister", "Please dont mess with the request!");
                response.sendRedirect("forum.php");
            } catch (IOException ex1) {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
