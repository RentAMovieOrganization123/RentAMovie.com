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
@WebServlet(name = "ProfileManagement", urlPatterns = {"/profile.php"})
public class ProfileManagement extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        User user = (User) request.getSession().getAttribute("user");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='assets/css/template.css'/>");
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/javascript.js\" ></script>");
            out.println("<title>Servlet ProfileManagement</title>");
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
            out.println("<h1>ProfileManagement</h1>");
            out.println("</content>");
            out.println("<table  style = \"width:100%\">"
                    + "<tr><td></td></tr>"
                    + "<tr><td>Username: "+user.getUserName()+" </td></tr>"
                    + " <tr><td>Birthdate: "+user.getBirthDate().toString()+"</td> </tr> "
                    + " <tr><td>Country: "+user.getCountry()+"</td> </tr> "
                    + "<tr><td>Profile pic: <img src=\"/ImagePresentation\" height=\"42\" width=\"42\" ></td></tr> "
                    
                    + "</table>"); 
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
