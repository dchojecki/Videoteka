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

@WebServlet(name = "wypozyczsql", urlPatterns = {"/wypozyczsql"})
public class wypozyczsql extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); 
      req.setCharacterEncoding("UTF-8"); 
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
         
      String strKlient = req.getParameter("klient");
      String strPlyta = req.getParameter("plyta");
      
      java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
      out.println("<center><h1> Wypożyczanie </h1><h2> <br>");
      
      
      out.println("</h2>");
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
             
 
            String wyslij = "INSERT INTO wypozyczenie (klient_idklient,kolekcja_id,od_data)VALUES ('" + strKlient + "','" + strPlyta + "','"+date+"')";
 
            

            stmt.executeUpdate(wyslij);
            }
            catch(Exception e)
            {
            out.println(e);
            }
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
           
 
            String wyslij = "UPDATE kolekcja SET dostepnosc = 0 WHERE id = ('" + strPlyta + "')";
 
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