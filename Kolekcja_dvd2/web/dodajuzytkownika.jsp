<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

        <link rel="stylesheet" type="text/css" href="<c:url value='css/style2.css'/>" />

        <title>Menu Główne Użytkownika</title>
    </head>
    
    <body>

        <div id="top">

            <div id="NAGLOWEK" >

                <center> 
                    <div id="transbox"> 
                        <h1> Witaj w wypożyczalni płyt DVD</h1>

                    </div>
                </center>
            </div>

            <div id="MENU">
                <div id="transbox">
                    <center><h3>Wypożyczenia:</h3></center>
                </div>

                <ul id="ul">
                    <li>
                        <form name="wypozycz" action="wypozycz" method="POST"> 
                            <input type="submit" value="Wypożycz płytę" name="wypozycz" />
                        </form>
                    </li>
                    <li>
                        <form name="listawypozyczen" action="listawypozyczen" method="POST">
                            <input type="submit" value="  Lista wypożyczeń   " name="listawypozyczen" />
                        </form>
                    </li>
                    <li>
                        <form name="historiawypozyczen" action="historiawypozyczen" method="POST">
                            <input type="submit" value="  Historia wypożyczeń   " name="historiawypozyczen" />
                        </form>
                    </li>
                </ul>


                <div id="transbox">
                    <center><h3>Płyty DVD:</h3></center>
                </div>
                <ul id="ul">
                    <li>
                        <form name="listaplytd" action="listaplytd" method="POST"> 
                            <input type="submit" value="  Lista dostępnych płyt  " name="listplytd" />
                        </form>
                    </li>
                    <li>
                        <form name="listaplyt" action="listaplyt" method="POST"> 
                            <input type="submit" value="  Lista płyt  " name="listplyt" />
                        </form>
                    </li>
                    <li>
                        <form name="dodajPlyte" action="dodajplyte.jsp" method="POST">
                            <input type="submit" value="  Dodaj płytę   " name="dodajplyte" />
                        </form>
                    </li>

                </ul>

                <div id="transbox">
                    <center><h3>Klienci:</h3></center>
                </div>

                <ul id="ul">
                    <li>
                        <form name="listaklientow" action="listaklientow" method="POST"> 
                            <input type="submit" value="  Lista klientów   " name="listaklientow" />
                        </form>
                    </li>
                    <li>
                        <form name="dodajklienta" action="dodajklienta.jsp" method="POST">
                            <input type="submit" value="  Dodaj klienta   " name="dodajklienta" />
                        </form>
                    </li>
                </ul>

                <div id="transbox">
                    <center><h3>Użytkownik:</h3></center>
                </div>

                <ul id="ul">
                    <li>
                        <form name="dodajuzytkownika" action="dodajuzytkownika.jsp" method="POST"> 
                            <input type="submit" value="  Dodaj nowego użytkownika   " name="dodajuzytkownika" />
                        </form>
                    </li>
                    
                </ul>

            </div>

            <div id="TRESC">

                <center>
        <h1>Dodawanie użytkowników</h1>
        
        <form action="dodajUzytkownika" method="POST">
            <b>
                <br><h3>Wprowadź dane użytkownika</h3> <br>
                <table border="0">
                    <thead>
                        <tr>
                            <td>Login:</td>
                            <td><input type="text" name="login"></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Imię:</td>
                            <td><input type="text" name="imie"></td>
                        </tr>
                        <tr>
                            <td>Nazwisko:</td>
                            <td><input type="text" name="nazwisko"></td>
                        </tr>
                        <tr>
                            <td>Hasło:</td>
                            <td><input type="password" name="haslo"></td>
                        </tr>
                        <tr>
                            <td>Uprawnienie:</td>
                            <td><input type="radio" name="uzytkownik" value="0" checked="checked" />Użytkownik<br>
                            <input type="radio" name="uzytkownik" value="1" />Administrator</td>
                        </tr>
                    </tbody>
                </table>

                
               
                </b><br>
                <input type="submit" value="Dodaj Użytkownika"/><br>
                 <%
                    String uzytkownik;
                    uzytkownik = (String)request.getAttribute("dodaj_uzytkownika");
                    
                    if(uzytkownik==null){
                            
                        }
                    else{
                        out.println("Dodano do bazy użytkownika "+"<b>"+uzytkownik+"</b>");
                    }
                %>
        </form>


     </center>

            </div>

            <div id="STOPKA">
                <p>Jesteś zalogowany jako: <%=session.getAttribute("Login")%> &nbsp;&nbsp;

                    <a href = "login.jsp"> (Wyloguj) </a></p>


            </div>








        </div>
    </body>
</html>
    
    

