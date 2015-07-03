package pl.damian_sebastian.zaliczenie;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "listaklientow", urlPatterns = {"/listaklientow"})
public class listaklientow extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); 
      req.setCharacterEncoding("UTF-8"); 
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      
      HttpSession session = req.getSession(true);
        String userName=(String)session.getAttribute("Login");
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
            
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
                            out.println("<input type=\"submit\" value=\"  Lista wypożyczeñ   \" name=\"listawypozyczen\" />");
                        out.println("</form>");
                    out.println("</li>");
                    out.println("<li>");
                        out.println("<form name=\"historiawypozyczen\" action=\"historiawypozyczen\" method=\"POST\">");
                            out.println("<input type=\"submit\" value=\"  Historia wypożyczeñ   \" name=\"historiawypozyczen\" />");
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

                ResultSet rs = stmt.executeQuery("SELECT * FROM klient");               
         out.println("<center><h1> Lista klientów </h><br> <br>");                                                                                
         out.println("<table border=1>"); 
         out.println("<thead><tr><th> Lp. </th><th> Imię </th><th>Nazwisko</th><th>Adres</th><th>Telefon</tr></thead>");
         while (rs.next())                                                                                  
         {                                                                                                  
            out.println("<thead><tr><th>"+rs.getInt(1)+"</th><th>"+rs.getString(2)+"</th><th>"+rs.getString(3)+"</th><th>"+rs.getString(4)+"</th><th>"+rs.getString(5)+"</tr></thead>");                   
         
         
           
         }                                                                                                  
         out.println("</table>");

            out.println("</div>");

            out.println("<div id=\"STOPKA\">");
                 out.println("<p>Jesteś zalogowany jako: "+userName+" &nbsp;&nbsp;");

                    out.println("<a href = \"login.jsp\"> (Wyloguj) </a></p>");

            out.println("</div>");
 
                                                                                        
                                                                                                            
         rs.close();                                                                                        
         stmt.close();                                                                                        
         con.close();                                                                                         
      }                                                                                                     
      catch (Exception e)                                                                                
      {                                                                                                     
         out.println(e);                                                                                     
      }
      
      
      out.println("</center>");
      out.close();
   }
}