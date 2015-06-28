/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class kolekcja extends HttpServlet {
     
  public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); 
      req.setCharacterEncoding("UTF-8"); 
       res.setContentType("text/html");
      PrintWriter out = res.getWriter();
         int logowanie=0;
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
            ResultSet rs = stmt.executeQuery("SELECT * FROM uzytkownik");               
         
         String strLogin = req.getParameter("Login");
      String strHaslo = req.getParameter("Haslo");
      int uprawnienie;
         while (rs.next())                                                                                  
         {                                                                                                  
          uprawnienie = rs.getInt(6);
   if (strLogin.equals(rs.getString(2)) && strHaslo.equals(rs.getString(3)))
    {
        if(uprawnienie == 1){
            out.println("<center><BR>");
            out.println("<h1>Witaj "+rs.getString(4)+"  "+rs.getString(5));
            out.println("<BR>Jesteś zalogowany jako administrator</h><BR>");
            logowanie=1;
            out.println("<br><form action=\"menua.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Przejdz do menu administratora\"/>\n" +
" </form></center>");
        //getServletContext().getRequestDispatcher("/menua.jsp") .forward(req,res);
        }else
        {
            out.println("<center><BR>");
            out.println("<h1>Witaj "+rs.getString(4)+" "+rs.getString(5));
            out.println("<BR>Poziom dostępu - uzytkownik</h><BR>");
            logowanie=1;
            out.println("<br><form action=\"menu.jsp\" method=\"POST\">\n" +
"<input type=\"submit\" value=\"Przejdz do menu\"/>\n" +
" </form></center>");
           
        }
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
      if (logowanie == 0){
    out.println("<BR>");
    out.println("<h1><center>Logowanie nieudane<br>Zły login lub hasło </h1></center>");
            
      }
      


      out.close();
   }
}