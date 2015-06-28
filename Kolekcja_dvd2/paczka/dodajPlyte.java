/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

@WebServlet(name = "dodajPlyte", urlPatterns = {"/dodajPlyte"})
public class dodajPlyte extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); 
      req.setCharacterEncoding("UTF-8"); 
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      
      //dodanie samochodu z formatki
      String strTytul = req.getParameter("tytul");
      String strOpis = req.getParameter("opis");
      String strGatunek = req.getParameter("gatunek");
      String strRok = req.getParameter("rok");
      
      
      out.println("<center><h1> Dodaje płytę</h1><h2> <br>");
      out.println("Tytuł - "+strTytul +"<br>Opis  -"+ strOpis +"<br>"+"Gatunek -"+ strGatunek + "<br> Rok -" + strRok ); 
      
      out.println("</h2>");
      
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
           //insert danych samochodu z formatki do bazy dancyh 
            String wyslij = "INSERT INTO kolekcja (tytul,opis,gatunek,rok,dostepnosc)VALUES ('" + strTytul + "','" + strOpis + "','" + strGatunek + "','" + strRok + "','1')";
 
            stmt.executeUpdate(wyslij);
            }
            catch(Exception e)
            {
            out.println(e);
            }
      
      
      
      out.println("<form action=\"menu.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Powrót do Menu\"/>\n" +
" </form>");
      out.println("<form action=\"dodajsamochod.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Dodaj następny samochód\"/>\n" +
" </form>");
      out.println("</center>");
      out.close();
   }
}