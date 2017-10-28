/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.cbehind;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tom.watteny
 */
@WebServlet(name = "cbehindRegister_submit.php", urlPatterns = {"/cbehindRegister_submit.php"})
public class cbehindRegister_submit extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           //parameters request
           String username = request.getParameter("input_username").trim();
           String country = request.getParameter("input_country").trim();
           Date birth_date = new Date(request.getParameter("input_birth_date"));
           String password = request.getParameter("input_password");
           String verify_password = request.getParameter("input_verifypassword");
           
           //image
           String imageLocation = request.getParameter("input_profile_picture");
           //... do more with picture
           
           //VALIDATION
           boolean valid = true;
           
           //VALIDATION USERNAME
           if(username.contains("<script>"))
           {
               valid = false;
               //set validator label valusername value to...
           }
           
           if(username.length() < 6)
           {
               valid = false;
               //set validator label valusername value to...
           }
           
           //CHECKUP IF EXISTS
           //if(username == usernameExists())
           //{
               //valid =false;
               //set validator label valusername value to...
           //}
           
           //VALIDATION COUNTRY
           if(country.contains("<script>"))
           {
               valid = false;
               //set validator label valcountry value to...
           }
           
           //VALIDATION PROFILE PICTURE
           //CHECK SIZE
           
           //VALIDATION DATE 
           //none?
           
           //VALIDATION PASSWORD
           if(password.length() < 8)
           {
               valid = false;
               //set validator label valpassword value to...
           }
           
           if(password.contains("<script>"))
           {
               valid = false;
               //set validator label valpassword value to...
           }
           
           //VALIDATION PASSWORD VERIFY
           if(!verify_password.equals(password))
           {
               valid = false;
               //set validator label valverifypassword value to...
           }
           
           //done validation
           if(valid)
           {
               //do database stuff
               response.sendRedirect("/Registersuccessful.php");
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
