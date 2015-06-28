<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Dodaj płytę</title>
    </head>
    
    
    <body><center>
        <h1>Dodawanie Płyt</h1>
        
        <form action="dodajPlyte" method="POST">
            <b>
                <br><h3>Wprowadź dane płyty DVD</h3> <br>
                <table border="0">
                    <thead>
                        <tr>
                            <td>Tytuł:</td>
                            <td><input type="text" name="tytul" size="49"></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Opis:</td>
                            <td><textarea name="opis" cols="50" rows="10">Wpisz tutaj opis filmu </textarea></td>
                        </tr>
                        <tr>
                            <td>Gatunek:</td>
                            <td><input type="text" name="gatunek" size="49"></td>
                        </tr>
                        <tr>
                            <td>Rok:</td>
                            <td><input type="text" name="rok" size="49"></td>
                        </tr>
                        
                        
                    </tbody>
                </table>

                
               
                </b><br>
<input type="submit" value="Dodaj Płytę"/>
        </form>

<form action="menu.jsp" method="POST">
<input type="submit" value="Powrót do Menu"/>
 </form>
    </body> </center>
</html>
