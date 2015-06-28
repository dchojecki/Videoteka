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
@WebServlet(name = "wypozycz", urlPatterns = {"/wypozycz"})
public class wypozycz extends HttpServlet {protected void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
      res.setCharacterEncoding("UTF-8"); //ustawienia kodowania
      req.setCharacterEncoding("UTF-8"); //ustawienia kodowania
    res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<center><h1>Wybierz </h1>");

try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:6033/wypozyczalnia", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
            Statement stmt2 = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klienci");  
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM samochody WHERE dostepnosc = 1");
            
            out.println("<h2>"+" Dane klienta "+"   "+" Dane samochodu "+"</h2>");
            out.println("<form  name = \"wypożycz\" action = \"wypozyczsql\" method=\"POST\">");                                                                                        
            out.println("<select name=\"klient\">");                                                       
         
         while (rs.next())                                                                                  
         {  
            out.println("<option value="+rs.getString(1)+">"+rs.getString(3)+" "+rs.getString(2)+" --> "+rs.getString(5)+"</option> ");
         }                                                                                                  
            out.println(" </select> ");
            out.println("<select name=\"samochód\">");   
         
         while (rs2.next())                                                                                  
         {   
            out.println("<option value="+rs2.getString(1)+">"+rs2.getString(2)+" "+rs2.getString(3)+" --> "+rs2.getString(4)+"</option> ");
         }                                                                                                  
            out.println(" </select> ");
            out.println("<br><br><input type=\"submit\" value=\"Wypożycz\"/></form></center>");                                                                                              
         rs.close();                                                                                        
         stmt.close();                                                                                        
         con.close();                                                                                         
      }                                                                                                     
      catch (Exception e)                                                                                
      {                                                                                                     
         out.println(e);                                                                                     
      }}}