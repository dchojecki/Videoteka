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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listawypozyczen", urlPatterns = {"/listawypozyczen"})
public class listawypozyczen extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); //ustawienia kodowania
      req.setCharacterEncoding("UTF-8"); //ustawienia kodowania
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
       int dvd=0;
       int kli=0;
       int id=0;
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
            Statement stmt2 = (Statement) con.createStatement();
            Statement stmt3 = (Statement) con.createStatement();
 
            
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM wypozyczenie WHERE do_data is null");               
         out.println("<center><h1> Lista Wypozyczeń </h><br> <br>");                                                                                
        out.println("<table border=1>");
        out.println("<thead><tr><th> Imię </th><th> Nazwisko </th><th> Adres</th><th> Telefon </th><th> Tytuł filmu</th><th>-----</tr></thead>");
         while (rs.next())                                                                                  
         { 
          dvd=rs.getInt(2);
          kli=rs.getInt(3);
          id=rs.getInt(1);
         ResultSet rs3 = stmt3.executeQuery("SELECT * FROM klient WHERE idklient = "+kli+" ");
         while (rs3.next()){
         out.println("<thead><tr><th>"+rs3.getString(2)+"</th><th>"+rs3.getString(3)+"</th><th>"+rs3.getString(4)+"</th><th>"+rs3.getString(5)+"</th>");    
         
         }
          ResultSet rs2 = stmt2.executeQuery("SELECT * FROM kolekcja WHERE id = "+dvd+" ");
         while (rs2.next()){
         out.println("<th>"+rs2.getString(2)+"</th><th><form name=\"oddaj\" action=\"oddaj\" method=\"POST\">\n" +
"    <input type=\"hidden\" name=\"id\"  value="+rs.getInt(1)+"><input type=\"hidden\" name=\"oddaj\"  value="+rs2.getInt(1)+"><input type=\"submit\" name=\"unused\" value=\"Oddaj\"/>\n" +
"     </form></tr></thead>");    
         
         }   
         
         } 
         
         out.println("</table>");                                                                            
                                                                                                            
         rs.close();                                                                                        
         stmt.close();                                                                                        
         con.close();                                                                                         
      }                                                                                                     
      catch (Exception e)                                                                                
      {                                                                                                     
         out.println(e);                                                                                     
      }
      out.println("<br><form action=\"index.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Powrót do menu\"/>\n" +
" </form>");
      
      out.println("</center>");
      out.close();
   }
}