/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Repositories;
import Model.Ticket;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AXANO
 */
@WebServlet(name = "AdminPage", urlPatterns = {"/AX7882BR19Olzze543Dr.php"})
public class AdminPage extends HttpServlet {

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
        List<Ticket> tickets = Repositories.getTicketRepository().getAllTickets();
        User admin = (User) request.getSession().getAttribute("user");
        if (!admin.getIsAdmin().equals("SuperUnpredictableStringUsedToIdentifyAdmins123456789???")) {
            request.getSession().setAttribute("messageToUser","Only Admins can Access this page!");
            response.sendRedirect("/");
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='assets/css/template.css'/>");
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/javascript.js\" ></script>");
            out.println("<title>Servlet AdminPage</title>");
            out.println("</head>");
            out.println("<body>");
            //header
            out.println("<header>");
            out.println("<nav>");
            out.println("<li><a href='index.php'>Home</a></li>");
            out.println("<li><a href='forum.php'>Forum</a></li>");
            out.println("<li><a href='profile.php'>Profile</a></li>");
            out.println("<li><a href='logout.php'>Login</a></li>");
            out.println("</nav>");
            out.println("</header>");
            //end header
                
            //content
            out.println("<content>");
            out.println("<h1>Servlet AdminPage</h1>");
            out.println("<h2>Support Tickets</h2>");
            
            out.println(" <table style=\"width:100%\">\n"
                    +" <thead>"
                    + "  <tr>\n"
                    + "    <th>ID</th>\n"
                    + "    <th>User</th>\n"
                    + "    <th>Date</th>\n"
                    + "    <th>Message</th>\n"
                    + "  </tr>"
                    +" </thead> "
                    + "<tbody align=\"center\">");
            for (Ticket t : tickets) {
                
                out.println("<tr>");
                out.println("<td>"+t.getID()+"</td>");
                out.println("<td>"+t.getContentOwner().getUserName()+"</td>");
                
                out.println("<td>"+t.getDateOfCreation().toString()+"</td>");
                out.println("<td>"+t.getMessage()+"</td>");
                out.println("</tr>");
            }   
            out.println("</tbody>");
                    out.println("</table>");
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
