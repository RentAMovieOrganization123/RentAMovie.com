/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.cbehind;

import Database.Repositories;
import Model.Ticket;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import static util.RecaptchaValidator.verifyResponse;

@WebServlet(name = "cbehindSupportTicket_submit.php", urlPatterns = {"/cbehind_SupportTicket_submit.php"})
public class cbehindSupportTicket_submit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String message = request.getParameter("message");
            Ticket ticket = new Ticket(0,user,message);
            Repositories.getTicketRepository().insertTicket(ticket);
            String googleResponse = request.getParameter("g-recaptcha-response");
            if (verifyResponse(googleResponse)) {
                request.getSession().setAttribute("messageToUser","Captcha niet ingevuld!");
            response.sendRedirect("/register.php");
            return;
            }
            String resultMessage = "Ticket successfully send";
            request.getSession().setAttribute("messageToUser",resultMessage);
            response.sendRedirect("/support.php");
                   
            
            
        } catch (JSONException ex) {
            Logger.getLogger(cbehindSupportTicket_submit.class.getName()).log(Level.SEVERE, null, ex);
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
