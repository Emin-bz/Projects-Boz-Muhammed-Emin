<?php
include('../connector.inc.php');
?>
<!DOCTYPE html>
<html lang="en">
  <head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Todo-Listen</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  </head>
  <body>
 
  <form action="" method="POST">

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Willkommen Emin Boz</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li class ="active"><a href="#">TODO-Einträge</a></li>
      <li>
      <a href="../kategorien.php">Kategorien erstellen</a></li>
      <li>
      <a href="../user_has_kategorie.php">Kategorien zuweisen</a></li>
     <li>
      <a href="../benutzer.php">Benutzer verwalten</a></li>
     
    
      <li><a href="../logout.php">Ausloggen</a></li>
    </ul>
  </div>
</nav>





<div class="well well-sm">
<h2>TODO Einträge aller Benutzer</h2>
<br>
<table class="table table-striped table-condensed">
    <thead>
      <tr>
        <th>Nr.</th>

        <th>Priorität (1-5)</th>
        <th>Kategorie</th>
        <th>Titel</th>
        <th>Beschreibung</th>
        <th>Erstellt</th>
        <th>Verfalltag </th>

        <th>Löschen</th>
       
        <th>Archivieren</th>
        <th>Ändern</th>

</th>
</tr>
</thead>

</div>
</table>


<tbody> 

</tbody>






</form>
  </body>
  </html>


