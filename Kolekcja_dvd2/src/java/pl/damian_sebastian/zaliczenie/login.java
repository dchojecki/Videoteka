package pl.damian_sebastian.zaliczenie;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class login extends HttpServlet {

    String logowanie;
    String user = null;
    String pass = null;
    Connection con = null;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");

            user = req.getParameter("Login");
            pass = req.getParameter("Haslo");
            String q = "SELECT * FROM uzytkownik where login='" + user + "' and haslo='" + pass + "'";

            HttpSession session = req.getSession(false);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            String username = null;
            String password = null;
            
            ServletContext context=getServletContext(); 

            while (rs.next()) {
                username = rs.getString(2);
                password = rs.getString(3);

                System.out.println(user + " " + pass);
                if (username.equals(user) && password.equals(pass)) {
                    req.getSession(true);
                    System.out.println("Zalogowano prawidłowo");
                    session.setAttribute("Login", user);
                    session.setAttribute("upr", Integer.toString(rs.getInt(6)));
                    RequestDispatcher dis = req.getRequestDispatcher("/index.jsp");
                    dis.forward(req, res);
                    System.out.println("Sprawdzanie indeksu uprawnienia ktory wynosi dla "+user+" "+rs.getInt(6));

                } 
            }
            System.out.println("Zalogowano nie prawidłowo");
            //session.invalidate();
            req.setAttribute("errorMessage", "Podałeś nieprawidłowy login lub hasło");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, res);
            

            out.println("Weszłeś do aplikacji");
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }

        out.close();
    }

}
