<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Dodaj klienta </title>
    </head>
    <body style="background: url('klienci.jpg') ; background-repeat:no-repeat"><center>
        <h1> Dodawanie klienta </h1>
        
        <form action="dodajKlienta" method="POST">
            <b>
                <br><h3>Wprowadź dane klienta wypożyczalni</h3> <br>
                <table border="0">
                    <thead>
                        <tr>
                            <td>Imię:</td>
                            <td><input type="text" name="kimie"></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Nazwisko:</td>
                            <td><input type="text" name="knazwisko"></td>
                        </tr>
                        <tr>
                            <td>Adres:</td>
                            <td><input type="text" name="adres"></td>
                        </tr>
                        <tr>
                            <td>Telefon:</td>
                            <td><input type="text" name="telefon"></td>
                        </tr>
                        
                    </tbody>
                </table>

                
               
                </b><br>
<input type="submit" value="Dodaj Klienta"/>
        </form>

<form action="menu.jsp" method="POST">
<input type="submit" value="Powrót do Menu"/>
 </form>
    </body> </center>
</html>
