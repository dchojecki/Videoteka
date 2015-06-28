


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


@WebServlet(name = "listaklientow", urlPatterns = {"/listaklientow"})
public class listaklientow extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setCharacterEncoding("UTF-8"); 
      req.setCharacterEncoding("UTF-8"); 
        res.setContentType("text/html");
      PrintWriter out = res.getWriter();
         
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");
 
            Statement stmt = (Statement) con.createStatement();
 
            ResultSet rs = stmt.executeQuery("SELECT * FROM klient");               
         out.println("<center><h1> Lista klientów </h><br> <br>");                                                                                
         out.println("<table border=1>"); 
         out.println("<thead><tr><th> Lp. </th><th> Imię </th><th>Nazwisko</th><th>Adres</th><th>T</tr></thead>");
         while (rs.next())                                                                                  
         {                                                                                                  
            out.println("<thead><tr><th>"+rs.getInt(1)+"</th><th>"+rs.getString(2)+"</th><th>"+rs.getString(3)+"</th><th>"+rs.getString(4)+"</th><th>"+rs.getString(5)+"</tr></thead>");                   
         
         
           
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