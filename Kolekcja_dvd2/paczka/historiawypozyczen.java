/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

/**
 *
 * @author Grzegorz & Grzegorz
 */
@WebServlet(name = "historiawypozyczen", urlPatterns = {"/historiawypozyczen"})
public class historiawypozyczen extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); //ustawienia kodowania
      req.setCharacterEncoding("UTF-8"); //ustawienia kodowania
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
       int sam=0;
       int kli=0;
       int id=0;
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:6033/wypozyczalnia", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
            Statement stmt2 = (Statement) con.createStatement();
            Statement stmt3 = (Statement) con.createStatement();
 
            
            //sprawdzenie daty wypozyczenie czy nie jest NULL
            ResultSet rs = stmt.executeQuery("SELECT * FROM wypozyczenie WHERE  data_od is not null");               
         out.println("<center><h1> Historia Wypożyczeń </h><br> <br>");                                                                                
        out.println("<table border=1>");
        out.println("<thead><tr><th> Nazwisko </th><th> Imię </th><th> Prowo jazdy </th><th> Marka </th><th> Model </th><th>Nr rejestracyjny</th><th>Data wypozyczenia</th><th>Data oddania</th></thead>");
         while (rs.next())                                                                                  
         { 
          sam=rs.getInt(3);
          kli=rs.getInt(2);
          id=rs.getInt(1);
         ResultSet rs3 = stmt3.executeQuery("SELECT * FROM klienci WHERE idklienci = "+kli+" ");
         while (rs3.next()){
         out.println("<thead><tr><th>"+rs3.getString(3)+"</th><th>"+rs3.getString(2)+"</th><th>"+rs3.getString(5)+"</th>");    
         
         }
          ResultSet rs2 = stmt2.executeQuery("SELECT * FROM samochody WHERE idsamochody = "+sam+" ");
         while (rs2.next()){
         out.println("<th>"+rs2.getString(2)+"</th><th>"+rs2.getString(3)+"</th><th>"+rs2.getString(4)+"</th><th>"+rs.getString(5)+"</th><th>"+rs.getString(4)+"</th></thead>");    
         
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
      out.println("<br><form action=\"menu.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Powrót do menu\"/>\n" +
" </form>");
      
      out.println("</center>");
      out.close();
   }
}