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

/**
 *
 * @author Grzegorz & Grzegorz
 */
@WebServlet(name = "dodajUzytkownika", urlPatterns = {"/dodajUzytkownika"})
public class dodajUzytkownika extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); //ustawienia kodowania
      req.setCharacterEncoding("UTF-8"); //ustawienia kodowania
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      //wpisanie urzytkownika z formatki   
      String strLogin = req.getParameter("login");
      String strImie = req.getParameter("imie");
      String strNazwisko = req.getParameter("nazwisko");
      String strHaslo = req.getParameter("haslo");
      String strRola = req.getParameter("Uzytkownik");
      
      out.println("<center><h1> Dodaje Użytkownika</h1><h2> <br>");
      out.println("Nazwisko i Imię - "+strNazwisko +" "+ strImie +"<br>"+"Login -"+ strLogin +"<br>"+"Rola -"+ strRola); 
      out.println("<br> Rola 0 = Użytkownik , 1 = Administrator");
      out.println("</h2>");
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:6033/wypozyczalnia", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
           //insert danych uzytkowanika z formatki do bazy dancyh
 
            String wyslij = "INSERT INTO users (login,nazwisko,imie,rola,haslo)VALUES ('" + strLogin + "','" + strNazwisko + "','" + strImie + "','" + strRola + "','" + strHaslo + "')";
 
            stmt.executeUpdate(wyslij);
            }
            catch(Exception e)
            {
            out.println(e);
            }
      
      
      
      
      
      
      out.println("<form action=\"menua.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Powrót do menu\"/>\n" +
" </form>");
      out.println("<form action=\"dodajuzytkownika.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Dodaj następnego użytkownika\"/>\n" +
" </form>");
      out.println("</center>");
      out.close();
   }
}