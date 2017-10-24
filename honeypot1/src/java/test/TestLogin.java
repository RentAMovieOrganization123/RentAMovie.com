/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Database.Repositories;
import Model.User;
import googleReCAPTCHAv2.VerifyRecaptcha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AXANO
 */
@WebServlet(name = "Test.php", urlPatterns = {"/Test.php"})
public class TestLogin extends HttpServlet {

    //VERWERKT EEN REQUEST EN CONTROLEERD OF DE PWD CORRECT IS 
    //ALS DIT ZO IS INITIALISEERD DEZE CLASS DE SESSION MET EEN PARAMETER
    //userName EN MET ALS WAARDE DE NAAM VAN HET USER OBJECT
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session = request.getSession();
           String username = request.getParameter("username");
           String userPassword = request.getParameter("password");
            System.out.println(userPassword);
            
            //User user=Repositories.getUserRepository().getUserByName(username);
            User user = new User("BAKOUROS","MICHALIS","PEPIS",new Date(),"Greece");
            if (userPassword.equals(user.getPassword())) {
                out.println("password correct");
                session.setAttribute("userName", user.getName());
                response.sendRedirect("/TestLoginSuccess.php");
            }
            else{
                
                session.setAttribute("failedLogin", "true");
                response.sendRedirect("/index.php");
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
