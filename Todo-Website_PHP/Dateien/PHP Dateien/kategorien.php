<?php
session_start();
include('connector.inc.php');
?>
<!DOCTYPE html>
<html lang="en">
  <head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Benutzer und Kategorien</title>
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
      <li><a href="Todo/todo_liste.php">TODO-Einträge</a></li>
      <li class ="active"> <a href="kategorien.php">Kategorien erstellen</a></li>
      <li>
      <a href="user_has_kategorie.php">Kategorien zuweisen</a></li>
      <li>
      <a href="benutzer.php">Benutzer verwalten</a></li>
      <li><a href="logout.php">Ausloggen</a></li>
    </ul>
  </div>
</nav>

<br> <br>


        <label for="kategorie">Kategorie erstellen: </label>
        <input type="text" name="kategorie" class="form-control" id="kategorie"
                  placeholder="Zum Kategorie erstellen hier eingeben"
                  maxlength="30"
                  pattern="(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{1,}">
        </div>    

    <br>
    <button type="submit" name="katerstellen" class="btn btn-primary">Erstellen</button>
      </br>
      <br>
      </br>
        
<?php

$submit = '';

if (isset($_POST['erstellen'])) {
  $_POST['erstellen'] = $submit;
 header("Location: kategorien_erstellen.php");
}

?>



<div class="well well-sm">
<h2>Kategorien</h2>
<table class="table table-striped table-condensed">
    <thead>
      <tr>
        <th>Kategorien</th>
    
</th>
</tr>
</thead>
</div>
</table>

<tbody>
<?php

if(isset($_POST['kategorie']) && !empty(trim($_POST['kategorie']))){
  $kategorie = trim($_POST['kategorie']);
}

if(isset($_POST['kategorie']) && !empty(trim($_POST['kategorie'])) && isset($_POST['katerstellen'])){
  $erstellen = $_POST['katerstellen'];
}

$error = '';
$userid = '';
$catid = '';
$catname = '';

  if(!empty($kategorie)) {
  if(!$stmt = $mysqli->stmt_init()) {}
  if ($stmt->prepare("Insert into categorie (categorieName) values (?);")) {
  
    if(!$stmt->bind_param("s", $kategorie)) {}
      if(!$stmt->execute()) {}
      if(!$stmt->fetch()){}
      $stmt->close();

    if(isset($erstellen)) {
      header("Location: kategorien.php");
    }
    }
  }

  # Select Abfrage für die Tabelle "categorie".
    $query = "SELECT * FROM categorie;";
    $result = mysqli_query($mysqli, $query);
    $resultCheck = mysqli_num_rows($result);
    
    if ($resultCheck > 0) {
      while ($row = mysqli_fetch_assoc($result)) {
        $catid = $row['id'];
        $catname = $row['categorieName'];
        echo "<br>" . "<BLOCKQUOTE>" . $catname . "</BLOCKQUOTE>"; 
        }  
    }
    
    $mysqli->close();
   
?>
  </tbody>