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
      <li>
      <a href="kategorien.php">Kategorien erstellen</a></li>
      <li>
      <a href="user_has_kategorie.php">Kategorien zuweisen</a></li>
      <li class ="active"> 
      <a href="benutzer.php">Benutzer verwalten</a></li>
      <li><a href="logout.php">Ausloggen</a></li>
    </ul>
  </div>
</nav>       
<br>
</br>
<label for="benutzer_loeschen">Benutzer löschen (Benutzername eingeben): </label>
        <input type="text" name="benutzer_loeschen" class="form-control" id="benutzer_loeschen"
                  placeholder="Benutzernamen des zu löschenden Benutzers eingeben">
        </div>   
<br>
<button type="submit" name="loeschen" value="submit" class="btn btn-warning">Löschen</button>
  
        
<?php

$submit = '';

if (isset($_POST['erstellen'])) {
  $_POST['erstellen'] = $submit;
 header("Location: benutzer_erstellen.php");
}

if(isset($_POST['benutzer_loeschen']) && !empty(trim($_POST['benutzer_loeschen']))){
    $benutzer_loeschen = trim($_POST['benutzer_loeschen']);
  }

if(isset($_POST['loeschen'])){
    $loeschen = $_POST['loeschen'];
  }

  $stmt = $mysqli->stmt_init(); 
  $stmt->prepare("delete from `user` WHERE `user`.`username` = ?;");
  
    $stmt->bind_param("s", $benutzer_loeschen);
    $stmt->execute();
    //$stmt->bind_result($deleted_user);
    $stmt->fetch();
    $stmt->close();
 
    if (isset($loeschen)) {
    echo "Sie haben den Benutzer mit dem Benutzernamen" . " <b>" . $benutzer_loeschen . " </b>gelöscht."; 
    }
 
?>

<br>
</br>
<br>
<div class="well well-sm">
<h2>Benutzer <button type="submit" name="erstellen" value="submit" class="btn btn-info">Benutzer erstellen</button>  <button type="submit" name="katzuweisen" value="submit" class="btn btn-secondary">Kategorie zuweisen</button></h2>
<table class="table table-striped table-condensed">
    <thead>
      <tr>
        
        <th> </th> 
</th>
</tr>
</thead>
</div>
</table>

<tbody>
<?php

if(isset($_POST['katzuweisen'])) {
    header("Location: user_has_kategorie.php");
}

if(isset($_POST['kategorie']) && !empty(trim($_POST['kategorie']))){
  $kategorie = trim($_POST['kategorie']);
}

if(isset($_POST['kategorie']) && !empty(trim($_POST['kategorie'])) && isset($_POST['katerstellen'])){
  $erstellen = $_POST['katerstellen'];
}

$error = '';

if (empty($error)) {
# Select Abfrage für die Tabelle "user".
$query2 = "SELECT * FROM user;";
$result2 = mysqli_query($mysqli, $query2);
$resultCheck2 = mysqli_num_rows($result2);

if ($resultCheck2 > 0) {
  while ($row = mysqli_fetch_assoc($result2)) {
    echo "<BLOCKQUOTE>" . "<b>Benutzername: </b>" . $row['username'] . "</BLOCKQUOTE>" . "<br>" . "<br>";
  }
}
}
mysqli_close($mysqli);

?>
  </tbody>
  </form>