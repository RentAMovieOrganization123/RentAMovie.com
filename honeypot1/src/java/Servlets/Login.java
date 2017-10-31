/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.MySqlUserRepository;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Login", urlPatterns = {"/login.php"})
public class Login extends HttpServlet {

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
            out.println("<link rel='stylesheet' href='assets/css/login.css'/>");
            out.println("<script type=\"text/javascript\" src=\"assets/javascript/javascript.js\" ></script>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            //header
            out.println("<header>");
            out.println("<nav>");
            out.println("<li><a href='index.php'>Home</a></li>");
            out.println("<li><a href='forum.php'>Forum</a></li>");
            out.println("<li><a href='register.php'>Register</a></li>");
            out.println("<li><a href='profile.php'>Profile</a></li>");
            out.println("<li><a href='login.php'>Login</a></li>");
            out.println("</nav>");
            out.println("</header>");
            //end header
                      
            //content
            out.println("<content>");
             out.println("<form action='/action_page.php'>");
            out.println("<div class='imgcontainer'>");
            out.println("<img src='/assets/img/logo_howest.jpg' alt='Avatar' class='avatar'>");
            out.println("</div>");

            out.println("<div class='container'>");
            out.println("<label><b>Username</b></label>");
            out.println("<input id ='userName' type='text' placeholder='Enter Username' name='uname' required>");

            out.println("<label><b>Password</b></label>");
            out.println("<input type='password' placeholder='Enter Password' name='psw' required>");
        
            out.println("<button type='submit'>Login</button>");
            out.println("</div>");

            
            out.println("<div class='container'>");
            out.println("<button type='button' class='cancelbtn'>Cancel</button>");
            
            out.println("</div>");
            out.println("</form>");
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
        
        if(request.getSession()!= null){
            response.sendRedirect("/");
            System.out.println("<b>User with userId " + request.getParameter("userId") + " is already logged in</b>");
        } else {
            processRequest(request, response);
        }       
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
        
        MySqlUserRepository db = new MySqlUserRepository();
        
        String userName = request.getParameter("uname");
        User user = db.getUserByName(userName);
        
        boolean flag = user.getPassword().equals(request.getParameter("psw"));
        
        if(flag){
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.hashCode()); //We moeten dan wel een beter hashcode schrijven voor User.
            response.sendRedirect("/AdminPage.php");
        }
        
     
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
