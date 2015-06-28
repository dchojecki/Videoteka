<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Dodaj użytkownika</title>
    </head>
    <body><center>
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
<input type="submit" value="Dodaj Użytkownika"/>
        </form>

<form action="menua.jsp" method="POST">
<input type="submit" value="Powrót do Menu Administratora"/>
 </form>
    </body> </center>
</html>
