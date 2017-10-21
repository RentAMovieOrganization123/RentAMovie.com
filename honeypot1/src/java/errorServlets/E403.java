/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorServlets;

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
@WebServlet(name = "E403", urlPatterns = {"/403.php"})
public class E403 extends HttpServlet {

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
            
        response.setHeader("Server", " Microsoft-IIS/10.0 ");
        response.setHeader("X-Powered-By", "PHP/5.4.4-14+b1");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"> \n"
                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\"> \n"
                    + "<head> \n"
                    + "<title>Gedetailleerde fout IIS 10.0 - 404.0 - Not Found</title> \n"
                    + "<style type=\"text/css\"> \n"
                    + "<!-- \n"
                    + "body{margin:0;font-size:.7em;font-family:Verdana,Arial,Helvetica,sans-serif;} \n"
                    + "code{margin:0;color:#006600;font-size:1.1em;font-weight:bold;} \n"
                    + ".config_source code{font-size:.8em;color:#000000;} \n"
                    + "pre{margin:0;font-size:1.4em;word-wrap:break-word;} \n"
                    + "ul,ol{margin:10px 0 10px 5px;} \n"
                    + "ul.first,ol.first{margin-top:5px;} \n"
                    + "fieldset{padding:0 15px 10px 15px;word-break:break-all;} \n"
                    + ".summary-container fieldset{padding-bottom:5px;margin-top:4px;} \n"
                    + "legend.no-expand-all{padding:2px 15px 4px 10px;margin:0 0 0 -12px;} \n"
                    + "legend{color:#333333;;margin:4px 0 8px -12px;_margin-top:0px; \n"
                    + "font-weight:bold;font-size:1em;} \n"
                    + "a:link,a:visited{color:#007EFF;font-weight:bold;} \n"
                    + "a:hover{text-decoration:none;} \n"
                    + "h1{font-size:2.4em;margin:0;color:#FFF;} \n"
                    + "h2{font-size:1.7em;margin:0;color:#CC0000;} \n"
                    + "h3{font-size:1.4em;margin:10px 0 0 0;color:#CC0000;} \n"
                    + "h4{font-size:1.2em;margin:10px 0 5px 0; \n"
                    + "}#header{width:96%;margin:0 0 0 0;padding:6px 2% 6px 2%;font-family:\"trebuchet MS\",Verdana,sans-serif; \n"
                    + " color:#FFF;background-color:#5C87B2; \n"
                    + "}#content{margin:0 0 0 2%;position:relative;} \n"
                    + ".summary-container,.content-container{background:#FFF;width:96%;margin-top:8px;padding:10px;position:relative;} \n"
                    + ".content-container p{margin:0 0 10px 0; \n"
                    + "}#details-left{width:35%;float:left;margin-right:2%; \n"
                    + "}#details-right{width:63%;float:left;overflow:hidden; \n"
                    + "}#server_version{width:96%;_height:1px;min-height:1px;margin:0 0 5px 0;padding:11px 2% 8px 2%;color:#FFFFFF; \n"
                    + " background-color:#5A7FA5;border-bottom:1px solid #C1CFDD;border-top:1px solid #4A6C8E;font-weight:normal; \n"
                    + " font-size:1em;color:#FFF;text-align:right; \n"
                    + "}#server_version p{margin:5px 0;} \n"
                    + "table{margin:4px 0 4px 0;width:100%;border:none;} \n"
                    + "td,th{vertical-align:top;padding:3px 0;text-align:left;font-weight:normal;border:none;} \n"
                    + "th{width:30%;text-align:right;padding-right:2%;font-weight:bold;} \n"
                    + "thead th{background-color:#ebebeb;width:25%; \n"
                    + "}#details-right th{width:20%;} \n"
                    + "table tr.alt td,table tr.alt th{} \n"
                    + ".highlight-code{color:#CC0000;font-weight:bold;font-style:italic;} \n"
                    + ".clear{clear:both;} \n"
                    + ".preferred{padding:0 5px 2px 5px;font-weight:normal;background:#006633;color:#FFF;font-size:.8em;} \n"
                    + "--> \n"
                    + "</style> \n"
                    + " \n"
                    + "</head> \n"
                    + "<body> \n"
                    + "<div id=\"content\"> \n"
                    + "<div class=\"content-container\"> \n"
                    + "  <h3>HTTP-fout 404.0 - Not Found</h3> \n"
                    + "  <h4>De bron waarnaar u op zoek bent, is verwijderd, de bron is tijdelijk niet beschikbaar of de naam ervan is gewijzigd.</h4> \n"
                    + "</div> \n"
                    + "<div class=\"content-container\"> \n"
                    + " <fieldset><h4>Meest waarschijnlijke oorzaken:</h4> \n"
                    + "  <ul> 	<li>De opgegeven map of het opgegeven bestand bestaat niet op de webserver.</li> 	<li>De URL bevat een typefout.</li> 	<li>De toegang tot het bestand wordt beperkt door een aangepast filter of een aangepaste module, zoals URLScan.</li> </ul> \n"
                    + " </fieldset> \n"
                    + "</div> \n"
                    + "<div class=\"content-container\"> \n"
                    + " <fieldset><h4>Mogelijke oplossingen:</h4> \n"
                    + "  <ul> 	<li>Maak de inhoud op de webserver.</li> 	<li>Controleer de URL van de browser.</li> 	<li>Maak een traceringsregel om mislukte aanvragen voor deze HTTP-statuscode te volgen en bekijk vanuit welke module SetStatus wordt aangeroepen. Klik <a href=\"http://go.microsoft.com/fwlink/?LinkID=66439\">hier</a> voor meer informatie over het maken van een traceringsregel voor mislukte aanvragen. </li> </ul> \n"
                    + " </fieldset> \n"
                    + "</div> \n"
                    + " \n"
                    + "<div class=\"content-container\"> \n"
                    + " <fieldset><h4>Gedetailleerde foutinformatie:</h4> \n"
                    + "  <div id=\"details-left\"> \n"
                    + "   <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> \n"
                    + "    <tr class=\"alt\"><th>Module</th><td>&nbsp;&nbsp;&nbsp;IIS Web Core</td></tr> \n"
                    + "    <tr><th>Bericht</th><td>&nbsp;&nbsp;&nbsp;MapRequestHandler</td></tr> \n"
                    + "    <tr class=\"alt\"><th>Handler</th><td>&nbsp;&nbsp;&nbsp;StaticFile</td></tr> \n"
                    + "    <tr><th>Foutcode</th><td>&nbsp;&nbsp;&nbsp;0x80070002</td></tr> \n"
                    + "     \n"
                    + "   </table> \n"
                    + "  </div> \n"
                    + "  <div id=\"details-right\"> \n"
                    + "   <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> \n"
                    + "    <tr class=\"alt\"><th>Aangevraagde URL</th><td>&nbsp;&nbsp;&nbsp;http://http://192.168.30.29/</td></tr> \n"
                    + "    <tr><th>Fysiek pad</th><td>&nbsp;&nbsp;&nbsp;C:\\inetpub\\wwwroot\\</td></tr> \n"
                    + "    <tr class=\"alt\"><th>Aanmeldingsmethode</th><td>&nbsp;&nbsp;&nbsp;Anoniem</td></tr> \n"
                    + "    <tr><th>Aangemelde gebruiker</th><td>&nbsp;&nbsp;&nbsp;Anoniem</td></tr> \n"
                    + "     \n"
                    + "   </table> \n"
                    + "   <div class=\"clear\"></div> \n"
                    + "  </div> \n"
                    + " </fieldset> \n"
                    + "</div> \n"
                    + " \n"
                    + "<div class=\"content-container\"> \n"
                    + " <fieldset><h4>Meer informatie:</h4> \n"
                    + "  Deze fout betekent dat het bestand of de map niet bestaat op de server. Maak het bestand of de map en dien de aanvraag opnieuw in. \n"
                    + "  <p><a href=\"https://go.microsoft.com/fwlink/?LinkID=62293&amp;IIS70Error=404,0,0x80070002,15063\">Meer informatie &raquo;</a></p> \n"
                    + "   \n"
                    + " </fieldset> \n"
                    + "</div> \n"
                    + "</div> \n"
                    + "</body> \n"
                    + "</html> ");
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
