<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Menu Główne Administratora</title>
    </head>
    <body style="background: url('admin.jpg') ; background-repeat:no-repeat">
    <center>
        <h2>Wypożyczalnia Samochodów<br>Menu Główne Administratora</h2>
    </center>
   
    
    <h3>ADMINISTRATOR:</h3>
    
    <form name="dodajuzytkownika" action="dodajuzytkownika.jsp" method="POST"> 
    <input type="submit" value="  Dodaj nowego użytkownika   " name="dodajuzytkownika" />
    </form>
    <form name="Menu" action="menu.jsp" method="POST"> 
    <input type="submit" value="  Przejdź do menu użytkownika   " name="menu" />
    </form>
    
    
    </body>
</html>
