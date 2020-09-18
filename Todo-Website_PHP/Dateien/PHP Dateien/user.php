<?php

session_start();

$_SESSIION['exist'] = true;

if ($_SESSION['exist'] = true) {

    echo "Willkommen bei user.php.";


}else {

    header("Location: login.php");

}







?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registrierung</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">


  </head>
  <body>


    <br>
    <a href="logout.php?">Ausloggen</a>
    </br>




  </body>
  </html>


