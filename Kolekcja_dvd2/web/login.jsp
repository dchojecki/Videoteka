<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

        <link rel="stylesheet" type="text/css" href="css/style.css">

        <title>Strona logowania kolekcji filmów</title>
    </head>
    <body> 


        <div class="body"></div>
        <div class="grad"></div>
        <div class="header">
            <div>Wypożyczalnia<span>Video</span></div>
        </div>
        <br>
            <div class="login">
                <form action="login" method="POST" >

                    <div class="login">
                        <input type="text" placeholder="nazwa uzytkownika" name="Login"><br>
                        <input type="password" placeholder="hasło" name="Haslo"><br>
                        <input type="submit" value="Logowanie">
                    </div>


                </form>
            </div>
            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    </body>

</html>
