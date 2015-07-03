
package pl.damian_sebastian.zaliczenie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
      String strUpr = req.getParameter("uzytkownik");
      int Upr = Integer.parseInt(strUpr);
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
           //insert danych uzytkowanika z formatki do bazy dancyh
 
            String wyslij = "INSERT INTO uzytkownik (login,haslo,imie,nazwisko,uprawnienie)VALUES ('" + strLogin + "','" + strHaslo + "','" + strImie + "','" + strNazwisko + "','" + Upr + "')";
 
            stmt.executeUpdate(wyslij);
            
            req.setAttribute("dodaj_uzytkownika", strImie+" "+strNazwisko);
                     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dodajuzytkownika.jsp");
                     dispatcher.forward(req, res);
            
            }
            catch(Exception e)
            {
            out.println(e);
            }
      
     
      out.println("</center>");
      out.close();
   }
}