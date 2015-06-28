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
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dodajKlienta", urlPatterns = {"/dodajKlienta"})
public class dodajKlienta extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); 
      req.setCharacterEncoding("UTF-8"); 
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      
      //dane z formatki
      String strKimie = req.getParameter("kimie");
      String strKnazwisko = req.getParameter("knazwisko");
      String strAdres = req.getParameter("adres");
      String strTelefon = req.getParameter("telefon");
      
      out.println("<center><h1> Dodaje klienta</h1><h2> <br>");
      out.println("Imię i nazwisko - "+strKimie +" "+ strKnazwisko +"<br>"+"Adres -"+ strAdres +"<br>"+" Telefon -"+ strTelefon); 
      
      out.println("</h2>");
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
           //insert do bazy danych z danymi klienta z formatki
 
            String wyslij = "INSERT INTO klient (imie, nazwisko, adres, telefon)VALUES ('" + strKimie + "','" + strKnazwisko + "','" + strAdres + "','" + strTelefon + "')";
 
            stmt.executeUpdate(wyslij);
            }
            catch(Exception e)
            {
            out.println(e);
            }
     
      out.println("<form action=\"menu.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Powrót do Menu\"/>\n" +
" </form>");
      out.println("<form action=\"dodajklienta.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Dodaj następnego klienta\"/>\n" +
" </form>");
      out.println("</center>");
      out.close();
   }
}