


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
@WebServlet(name = "listasamochodow", urlPatterns = {"/listasamochodow"})
public class listasamochodow extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); //ustawienia kodowania
      req.setCharacterEncoding("UTF-8"); //ustawienia kodowania
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
         
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:6033/wypozyczalnia", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
            ResultSet rs = stmt.executeQuery("SELECT * FROM samochody WHERE dostepnosc = 1");               
         out.println("<center><h1> Lista samochodów </h><br> <br>");                                                                                
         out.println("<table border=1>"); 
         out.println("<thead><tr><th> Lp. </th><th> Marka </th><th> Model </th><th>Nr rejestracyjny</tr></thead>");
         while (rs.next())                                                                                  
         {                                                                                                  
            out.println("<thead><tr><th>"+rs.getInt(1)+"</th><th>"+rs.getString(2)+"</th><th>"+rs.getString(3)+"</th><th>"+rs.getString(4)+"</tr></thead>");                   
         
         
           
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