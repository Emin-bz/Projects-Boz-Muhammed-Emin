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
<br> <br>
<div class="container">
<a href="benutzer.php"><- Zurück</a>
<h1>Kategorie zuweisen</h1>
<br>
<label for="benutzer">Benutzername: </label>
<input type="text" name="benutzer" class="form-control" id="benutzer"
    placeholder="Den Benutzernamen eingeben">

<label for="kategorie">Kategorie: </label>
<input type="text" name="kategorie" class="form-control" id="kategorie"
    placeholder="Die Kategorie für den Benutzer eingeben"> 
<br>
<div class = "myButton">      
<button type="submit" name="zuweisen" value="submit" class="btn btn-info">Zuweisen</button>
</br>
<br>
</br>
</div>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Benutzernamen zur Auswahl</th>
    </tr>
  </thead>
<tbody>
<tr>
      
      <td><?php
    # Select Abfrage für die Tabelle "user".
    $query2 = "SELECT * FROM user;";
    $result2 = mysqli_query($mysqli, $query2);
    $resultCheck2 = mysqli_num_rows($result2);

    if ($resultCheck2 > 0) {
        while ($row = mysqli_fetch_assoc($result2)) {
        echo "- " . $row['username'] . "<br>" . "<br>";
     }
    }


      ?>
</td>
</tr>
</tbody>
</table>

<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Kategorien zur Auswahl</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
      <?php
    # Select Abfrage für die Tabelle "categorie".
    $query = "SELECT * FROM categorie;";
    $result = mysqli_query($mysqli, $query);
    $resultCheck = mysqli_num_rows($result);
 
    if ($resultCheck > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
     $catid = $row['id'];
     $catname = $row['categorieName'];
     echo "- " . $catname . "<br>" . "<br>"; 
     }  
    }
      ?>
      </td>

    </tr>
  
  </tbody>
</table>
        
<?php

if(isset($_POST['kategorie']) && !empty(trim($_POST['kategorie']))){
  $kategorie = trim($_POST['kategorie']);
}

if(isset($_POST['benutzer']) && !empty(trim($_POST['benutzer']))){
    $benutzer = trim($_POST['benutzer']);
  }

if(isset($_POST['kategorie']) && !empty(trim($_POST['kategorie'])) && isset($_POST['benutzer']) && isset($_POST['zuweisen'])){
  $zuweisen = $_POST['zuweisen'];
}

$error = '';
$userid = '';
$catid = '';
$catname = '';

  // Select Abfrage über die Tabelle "user".
  $stmt = $mysqli->stmt_init();
  if ($stmt->prepare("SELECT id FROM user where username = ?")) {
  
      $stmt->bind_param("s", $benutzer);
      $stmt->execute();
      $stmt->bind_result($result_benutzer);
      $stmt->fetch();
      $stmt->close();
    }

    // Select Abfrage über die Tabelle "categorie".
    $stmt = $mysqli->stmt_init();
    if ($stmt->prepare("SELECT id FROM categorie where categorieName = ?")) {
    
        $stmt->bind_param("s", $kategorie);
        $stmt->execute();
        $stmt->bind_result($result_kategorie);
        $stmt->fetch();
        $stmt->close();
      }

  if(!empty($kategorie) && !empty($benutzer)) {
    if(isset($zuweisen)) {
  
  $stmt = $mysqli->stmt_init();
  if ($stmt->prepare("Insert into user_has_categorie (id_user, id_categorie) values (?,?);")) {
      $stmt->bind_param("ss", $result_benutzer, $result_kategorie);
      $stmt->execute();
      $stmt->fetch();
      $stmt->close();

      header("Location: kategorien.php");
    }
  }
  }
  
?>
