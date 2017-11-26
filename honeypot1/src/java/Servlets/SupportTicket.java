/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AXANO
 */
@WebServlet(name = "SupportTicket", urlPatterns = {"/support.php"})
public class SupportTicket extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='assets/css/template.css'/>");
            out.println("<link rel='stylesheet' href='assets/css/SupportTicket.css'/>");
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/javascript.js\" ></script>");
            out.println("<script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>");
            out.println("<title>Submit a ticket</title>");            
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
            out.println("<h1>Contact us</h1>");
            String messageToUser = (String)request.getSession().getAttribute("messageToUser");
            if (messageToUser!=null){
            out.println("<h2 style=\"color:red;\">"+messageToUser+"</h2>");
            request.getSession().setAttribute("messageToUserRegister",null);
            }
            out.println("<form action='cbehind_SupportTicket_submit.php' method='post'>");
            out.println("<table>");
            out.println("<tbody>");
            
            out.println("<tr>");
            out.println("<td><label>Sender: </label></td>");
            out.println("<td>"+user.getUserName()+"</td>");
            out.println("<td><label class='val' name='sender'> test </label></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><label>Message: </label></td>");
            out.println("<td><textarea rows='10' cols='30' required name='message' id='input'> </textarea></td>");
            out.println("<td><label class='val' name='valmessage'> test </label></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan='3'><input type='submit' name='submit' value='Send message' id='formsubmit' /> </td>");
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
            out.println("</body>");
            out.println("</html>");
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
