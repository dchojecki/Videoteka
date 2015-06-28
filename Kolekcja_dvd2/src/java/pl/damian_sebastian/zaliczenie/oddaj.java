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

@WebServlet(name = "oddaj", urlPatterns = {"/oddaj"})
public class oddaj extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); 
      req.setCharacterEncoding("UTF-8"); 
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
         
      String strOddaj = req.getParameter("oddaj");
      String strId = req.getParameter("id");
      
      java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
      
      
      
      out.println("</h2>");
      
      
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
           
 
            String wyslij = "UPDATE kolekcja SET dostepnosc = 1 WHERE id = ('" + strOddaj + "')";
 
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
 
           
 
            String wyslij = "UPDATE wypozyczenie SET do_data = ('"+date+"') WHERE idwypozyczenie = ('" + strId + "')";
 
            stmt.executeUpdate(wyslij);
            }
            catch(Exception e)
            {
            out.println(e);
            }
      
      
      
      
      getServletContext().getRequestDispatcher("/historiawypozyczen") .forward(req,res);
      
      out.println("</center>");
      out.close();
   }
}