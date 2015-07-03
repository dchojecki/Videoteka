/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.damian_sebastian.zaliczenie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.swing.text.html.CSS.getAttribute;

@WebServlet(name = "wypozycz", urlPatterns = {"/wypozycz"})
public class wypozycz extends HttpServlet {
   
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8"); //ustawienia kodowania
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        HttpSession session = req.getSession();
        
        String userName=(String)session.getAttribute("Login");
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");

            Statement stmt = (Statement) con.createStatement();
            Statement stmt2 = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klient");
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM kolekcja WHERE dostepnosc = 1");
            
             
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menu Główne Użytkownika</title>");
            out.println("<link rel='stylesheet' href='css/style2.css' type='text/css'>");
            out.println("</head>");
            
            out.println("<body>");

                out.println("<div id=\"top\">");

            out.println("<div id=\"NAGLOWEK\" >");

                out.println("<center>"); 
                    out.println("<div id=\"transbox\">"); 
                        out.println("<h1> Witaj w wypożyczalni płyt DVD</h1>");

                    out.println("</div>");
                out.println("</center>");
            out.println("</div>");

            out.println("<div id=\"MENU\">");
                out.println("<div id=\"transbox\">");
                    out.println("<center><h3>Wypożyczenia:</h3></center>");
                out.println("</div>");

                out.println("<ul id=\"ul\">");
                    out.println("<li>");
                        out.println("<form name=\"wypozycz\" action=\"wypozycz\" method=\"POST\">"); 
                            out.println("<input type=\"submit\" value=\"Wypożycz płytę\" name=\"wypozycz\" />");
                        out.println("</form>");
                    out.println("</li>");
                    out.println("<li>");
                        out.println("<form name=\"listawypozyczen\" action=\"listawypozyczen\" method=\"POST\">");
                            out.println("<input type=\"submit\" value=\"  Lista wypożyczeń   \" name=\"listawypozyczen\" />");
                        out.println("</form>");
                    out.println("</li>");
                    out.println("<li>");
                        out.println("<form name=\"historiawypozyczen\" action=\"historiawypozyczen\" method=\"POST\">");
                            out.println("<input type=\"submit\" value=\"  Historia wypożyczeń   \" name=\"historiawypozyczen\" />");
                        out.println("</form>");
                    out.println("</li>");
                out.println("</ul>");


                out.println("<div id=\"transbox\">");
                    out.println("<center><h3>Płyty DVD:</h3></center>");
                out.println("</div>");
                out.println("<ul id=\"ul\">");
                    out.println("<li>");
                        out.println("<form name=\"listaplytd\" action=\"listaplytd\" method=\"POST\">"); 
                            out.println("<input type=\"submit\" value=\"  Lista dostępnych płyt  \" name=\"listplytd\" />");
                        out.println("</form>");
                    out.println("</li>");
                    out.println("<li>");
                        out.println("<form name=\"listaplyt\" action=\"listaplyt\" method=\"POST\">"); 
                            out.println("<input type=\"submit\" value=\"  Lista płyt  \" name=\"listplyt\" />");
                        out.println("</form>");
                    out.println("</li>");
                    out.println("<li>");
                        out.println("<form name=\"dodajPlyte\" action=\"dodajplyte.jsp\" method=\"POST\">");
                            out.println("<input type=\"submit\" value=\"  Dodaj płytę   \" name=\"dodajplyte\" />");
                        out.println("</form>");
                    out.println("</li>");

                out.println("</ul>");

                out.println("<div id=\"transbox\">");
                    out.println("<center><h3>Klienci:</h3></center>");
                out.println("</div>");

                out.println("<ul id=\"ul\">");
                    out.println("<li>");
                        out.println("<form name=\"listaklientow\" action=\"listaklientow\" method=\"POST\">"); 
                            out.println("<input type=\"submit\" value=\"  Lista klientów   \" name=\"listaklientow\" />");
                        out.println("</form>");
                    out.println("</li>");
                    out.println("<li>");
                        out.println("<form name=\"dodajklienta\" action=\"dodajklienta.jsp\" method=\"POST\">");
                            out.println("<input type=\"submit\" value=\"  Dodaj klienta   \" name=\"dodajklienta\" />");
                        out.println("</form>");
                    out.println("</li>");
                out.println("</ul>");

                out.println("<div id=\"transbox\">");
                    out.println("<center><h3>Użytkownik:</h3></center>");
                out.println("</div>");

                out.println("<ul id=\"ul\">");
                    out.println("<li>");
                        out.println("<form name=\"dodajuzytkownika\" action=\"dodajuzytkownika.jsp\" method=\"POST\">"); 
                            out.println("<input type=\"submit\" value=\"  Dodaj nowego użytkownika   \" name=\"dodajuzytkownika\" />");
                        out.println("</form>");
                    out.println("</li>");
                    
                out.println("</ul>");

            out.println("</div>");

            out.println("<div id=\"TRESC\">");

                out.println("<center>");

                    out.println("<table>");

                        out.println("<tr>"
                           + "<th><h2>Dane klienta </h2></th>"
                            + "<th><h2> Dane płyty DVD </h2></th>"
                     + "</tr>");
                         out.println("<tr>"
                            + "<td><br><center><form  name = \"wypoĹĽycz\" action = \"wypozyczsql\" method=\"POST\">");
                                out.println("<select name=\"klient\">");

                                 while (rs.next()) {
                                     out.println("<option value=" + rs.getString(1) + ">" + rs.getString(2) + " " + rs.getString(3) + " --> " + rs.getString(4) + "</option> ");
                                 }
                                    out.println(" </select></center></td> ");
                        out.println("<td><center><select name=\"plyta\">");

                                while (rs2.next()) {
                                     out.println("<option value=" + rs2.getString(1) + ">" + rs2.getString(2) + " " + rs2.getString(4) + " --> " + rs2.getString(5) + "</option> ");
                                }
                                     out.println(" </select> </center></td> </tr>");
              out.println("</table>");

              out.println("<br><input type=\"submit\" value=\"Wypożycz\"/></form></center>");

                    out.println("</center>");

            out.println("</div>");

            out.println("<div id=\"STOPKA\">");
                out.println("<p>Jesteś zalogowany jako: "+userName+" &nbsp;&nbsp;<br>");

                    out.println("<a href = \"login.jsp\"> (Wyloguj) </a></p>");
                        

            out.println("</div>");








        out.println("</div>");
          out.println("</body>");
          out.println("</html>");

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}
