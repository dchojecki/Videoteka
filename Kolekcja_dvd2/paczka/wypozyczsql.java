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

/**
 *
 * @author Grzegorz & Grzegorz
 */
@WebServlet(name = "wypozyczsql", urlPatterns = {"/wypozyczsql"})
public class wypozyczsql extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); //ustawienia kodowania
      req.setCharacterEncoding("UTF-8"); //ustawienia kodowania
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
         
      String strKlient = req.getParameter("klient");
      String strSamochud = req.getParameter("samochód");
      
      java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
      out.println("<center><h1> Wypożyczanie </h1><h2> <br>");
      
      
      out.println("</h2>");
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:6033/wypozyczalnia", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
             
 
            String wyslij = "INSERT INTO wypozyczenie (klienci_idklienci1,samochody_idsamochody,data_do)VALUES ('" + strKlient + "','" + strSamochud + "','"+date+"')";
 
            

            stmt.executeUpdate(wyslij);
            }
            catch(Exception e)
            {
            out.println(e);
            }
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:6033/wypozyczalnia", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
           
 
            String wyslij = "UPDATE samochody SET dostepnosc = 0 WHERE idsamochody = ('" + strSamochud + "')";
 
            stmt.executeUpdate(wyslij);
            }
            catch(Exception e)
            {
            out.println(e);
            }
      
      
      
      
      
      getServletContext().getRequestDispatcher("/listawypozyczen") .forward(req,res);
      
      out.println("</center>");
      out.close();
   }
}