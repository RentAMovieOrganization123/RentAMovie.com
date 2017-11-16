/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.cbehind;

import Database.Repositories;
import Model.User;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static Logging.Logger.logScriptUpload;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author AXANO
 */
@WebServlet(name = "cbehindRegister_submit.php", urlPatterns = {"/cbehindRegister_submit"})
@MultipartConfig
public class cbehindRegister_submit extends HttpServlet {
    String messageToUser= "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        messageToUser= "";
        try (PrintWriter out = response.getWriter()) {

            //parameters request
            final Part filePart = request.getPart("input_profile_picture");
            InputStream filecontent = filePart.getInputStream();
            byte[] image = IOUtils.toByteArray(filecontent);
            String username = request.getParameter("input_username");
            String country = request.getParameter("input_country");
            Date birth_date = df.parse(request.getParameter("input_birth_date"));
            String password = request.getParameter("input_password");
            String verify_password = request.getParameter("input_verifypassword");

            boolean valid = validate(username, country, password, verify_password, image, out,(ServletRequest)request);

            //done validation
            if (valid) {
                password = util.Hashing.sha256(password);
                //  public User(String name, String firstName, String userName, String password, Date birthDate, String country, byte[] profilePicture) {
                User user = new User("", "", username, password, birth_date, country, image ,"");
                Repositories.getUserRepository().insertUser(user);
                request.getSession().setAttribute("isLoggedIn", "true");
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/profile.php");
            }
            else{
                request.getSession().setAttribute("messageToUserRegister",messageToUser);
            response.sendRedirect("/register.php");}
        } catch (ParseException ex) {
            request.getSession().setAttribute("messageToUserRegister","You probably messed with the request. please try again!!");
            response.sendRedirect("/register.php");
            Logger.getLogger(cbehindRegister_submit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private boolean validate(String username, String country, String password, String verify_password, byte[] image, PrintWriter out, ServletRequest request) {

        boolean valid = true;

        if (username.contains("<script>")) {
            valid = false;

        }
        if (username.length() < 6) {
            valid = false;

        }
        if (image.length / (1024 * 1024) > 1) {
            messageToUser = messageToUser + "file is too big. ";
            valid = false;
        }
        if (!checkIfByteArrayIsImage(image)) {
            messageToUser = messageToUser + "file uploaded is no image. ";
            logScriptUpload(request);
            valid = false;
        }
        //CHECKUP IF EXISTS
        if (Repositories.getUserRepository().getUserByName(username) != null) {

            valid = false;
             messageToUser = messageToUser + "User Exists";
        }

        //VALIDATION COUNTRY
        if (country.contains("<script>")) {
            valid = false;
            //set validator label valcountry value to...
        }
        //VALIDATION PROFILE PICTURE
        //CHECK SIZE

        //VALIDATION DATE
        //none?
        //VALIDATION PASSWORD
        if (password.length() < 6) {
            valid = false;
            //set validator label valpassword value to...
        }
        if (password.contains("<script>")) {
            valid = false;
            //set validator label valpassword value to...
        }
        //VALIDATION PASSWORD VERIFY
        if (!verify_password.equals(password)) {
            valid = false;
             messageToUser = messageToUser + "password doesnt match with verify password field.";
        }
        return valid;
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

    private boolean checkIfByteArrayIsImage(byte[] imageByteArray) {
        try {
            Image image = ImageIO.read(new ByteArrayInputStream(imageByteArray));
            if (image == null) {
                return false;
            }
        } catch (IOException ex) {
            return false;

        }
        return true;
    }

}
