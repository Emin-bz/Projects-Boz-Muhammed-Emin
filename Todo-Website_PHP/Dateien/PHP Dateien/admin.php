<?php
session_start();

if ($_SESSION['erfolgreich'] === true) {
  //Login war erfolgreich
}else {
    header("Location: login.php");
}







?>

<!DOCTYPE html>
<html lang="en">
  <head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Adminbereich</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">


  </head>
  <body>


  <div class="alert alert-warning" role="alert">
  Willkommen im Admin-Bereich.
  </div>
  
 

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Willkommen Administrator</a>
    </div>
    <ul class="nav navbar-nav">
     <li>
      <a href="Todo/todo_liste.php">TODO-Einträge</a></li>
      <li>
      <a href="kategorien.php">Kategorien erstellen</a></li>
      <li>
      <a href="user_has_kategorie.php">Kategorien zuweisen</a></li>
      
      <li>
      <a href="benutzer.php">Benutzer verwalten</a></li>
      <li>
      <a href="logout.php">Ausloggen</a></li>
    </ul>
  </div>
</nav>
  </body>
  </html>