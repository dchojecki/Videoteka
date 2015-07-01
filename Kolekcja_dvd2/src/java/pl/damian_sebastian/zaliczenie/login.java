/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class login extends HttpServlet {

    int uprawnienie = 0;
    String logowanie = "0";

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dvd", "root", "");

            Statement stmt = (Statement) con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM uzytkownik");

            String strLogin = req.getParameter("Login");
            String strHaslo = req.getParameter("Haslo");

            HttpSession session = req.getSession();

            while (rs.next()) {
                uprawnienie = rs.getInt(6);
                if (strLogin.equals(rs.getString(2)) && strHaslo.equals(rs.getString(3))) {

                    //logowanie = 1;
                    
                    session.setAttribute("Login", req.getParameter("Login"));
                        res.sendRedirect("index.jsp");

                } else {
                    //http://forum.4programmers.net/Java/191696-servlet_przekazywnanie_parametrow_do_jsp
                    
                    req.setAttribute("zle_haslo", logowanie);
                     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                     dispatcher.forward(req, res);
                }
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }

        out.close();
    }

    public int sprUprawnienie() {

        return uprawnienie;
    }
}
