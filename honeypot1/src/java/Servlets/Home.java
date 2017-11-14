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
 
/**
 *
 * @author AXANO
 */
@WebServlet(name = "Home", urlPatterns = {"/index.php"})
public class Home extends HttpServlet {
   
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //request.getSession().invalidate();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");

            out.println("<link rel='stylesheet' href='assets/css/template.css'/>");
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/javascript.js\" ></script>");
            out.println("<script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>");
            out.println("<title>Index.php</title>");            
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
            out.println("<h1>Login</h1>");
            String loginFailed = (String)request.getSession().getAttribute("failedLogin");
            System.out.println((String)(String)request.getSession().getAttribute("failedLogin"));
            checkLoginStatus(loginFailed, out, request);
             out.println(" <form action = \"validate\" method = \"POST\">");
              

            out.println("Username: <input type = \"text\" name = \"userName\">");
            out.println("<br />\n"
                    + "Password: <input type = \"password\" name = \"password\" />\n"
                    + "<input type = \"submit\" name = \"submit\" value = \"Get!!!!\" />");
            //out.println("<div class=\"g-recaptcha\" data-sitekey=\"6LcciDUUAAAAAMs0rvPs5jg-oKg40t9_yBz3RRxJ\"></div>");
            out.println("</form>");
            out.println("<p style=\"color:red;\">You can only go to the Forum and to your profile if you are logged in!</p>");
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

    private void checkLoginStatus(String loginFailed, final PrintWriter out, HttpServletRequest request) {
        if (loginFailed != null &&loginFailed.equals("true")){
            out.println("<h2>Something went wrong please try logging in again</h2>");
        }
        request.getSession().setAttribute("failedLogin", "false");
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
