/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register", urlPatterns = {"/register.php"})

public class Register extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='assets/css/template.css'/>");
            
            out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.2.1/jquery.min.js\" type=\"text/javascript\"></script>");
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/javascript.js\" ></script>");
            out.println("<script type='text/javascript' src='assets/javascript/registrationValidator.js' ></script>");
            out.println("<script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>");
            out.println("<link rel='stylesheet' href='assets/css/register.css'/>");
            out.println("<title>Register</title>");    
            
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
            out.println("<h1>Register for free</h1>");
            String messageToUser = (String)request.getSession().getAttribute("messageToUserRegister");

            if (messageToUser!=null) {
                out.println("<h2 style=\"color:red;\">"+messageToUser+"</h2>");
                request.getSession().setAttribute("messageToUserRegister",null);
            }

            
            out.println("<form action='cbehindRegister_submit' method='post'enctype=\"multipart/form-data\">");

            out.println("<table>");
            out.println("<tbody>");

            out.println("<tr>");
            out.println("<td><label>Username: </label></td>");
            out.println("<td><input type='text' required id='input_username' name='input_username'/></td>");
            out.println("<td><label id='valusername' class='val'> </label></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><label>Country: </label></td>");
            out.println("<td><input type='text' required id='input_country' name='input_country'/></td>");
            out.println("<td><label id='valcountry' class='val'> </label></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><label>Profile picture(max 1 MB): </label></td>");
            out.println("<td><input type='file' required id='input_profile_picture' name='input_profile_picture' accept='image/x-png,image/gif,image/jpeg' /></td>");
            out.println("<td><label id='valprofile_picture' class='val'> </label></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><label>Birth date(DD/MM/YYYY): </label></td>");
            out.println("<td><input type='text' required id='input_birth_date' name='input_birth_date' required pattern=\"[0-9]{2}/[0-9]{2}/[0-9]{4}\"/></td>");
            out.println("<td><label id='valbrith_date' class='val'> </label></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><label>Password: </label></td>");
            out.println("<td><input type='password' required id='input_password' name='input_password' /></td>");
            out.println("<td><label id='valpassword' class='val'> </label></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><label>Verify password: </label></td>");
            out.println("<td><input type='password' required id='input_verifypassword' name='input_verifypassword' /></td>");
            out.println("<td><label id='valverifypassword' class='val' > </label></td>");
            out.println("</tr>");
         
            //request
            out.println("<tr>");
            out.println("<td height='45px' colspan='3'><input type='submit' id='submit' value='Registreer' id='regsubmit' /></td>");
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
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/registrationValidator.js\" ></script>");
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
