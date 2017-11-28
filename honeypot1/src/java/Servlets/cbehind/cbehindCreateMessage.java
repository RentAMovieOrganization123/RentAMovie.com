/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.cbehind;

import Database.Repositories;
import Model.Reaction;
import Model.Subject;
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

/**
 *
 * @author AHANO
 */
@WebServlet(name = "cbehindCreateMessage.php", urlPatterns = {"/cbehindCreateMessage.php"})
public class cbehindCreateMessage extends HttpServlet {

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
        String googleResponse = request.getParameter("g-recaptcha-response");
        try {
            if (verifyResponse(googleResponse)) {
                request.getSession().setAttribute("messageToUserRegister","Captcha niet ingevuld!");
                response.sendRedirect("/forum.php");
                return;
            }
        } catch (JSONException ex) {
            Logger.getLogger(cbehindCreateMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String message = (String) request.getParameter("message");
        
            if(message.length() <= 500){
                User user = (User) request.getSession().getAttribute("user");
                Subject subject = (Subject) request.getSession().getAttribute("subject");
                Reaction reaction = new Reaction(user,message,subject.getID());
                Repositories.getReactionRepository().insertReaction(reaction);
                request.getSession().setAttribute("messageToUserRegister","Message sent successfully");
                response.sendRedirect("/Messages.php?id="+subject.getID()+"");
            } else {
                
                 request.getSession().setAttribute("messageToUserRegister","Message length too long!");
                 response.sendRedirect("/Messages.php");
            
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
