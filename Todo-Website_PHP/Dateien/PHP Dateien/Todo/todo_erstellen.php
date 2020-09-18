<?php

include('../connector.inc.php');

$error = $message =  '';


$prio = ' ';
$todo = ' ';
$beschreibung = ' ';
$erledigt_bis = ' ';



if(isset($_POST['prio']) && !empty(trim($_POST['prio']))){
  $prio = trim($_POST['prio']);
} 



if(isset($_POST['todo']) && !empty(trim($_POST['todo']))){
  $todo = trim($_POST['todo']);

} 



if(isset($_POST['beschreibung']) && !empty(trim($_POST['beschreibung']))){
  $beschreibung = trim($_POST['beschreibung']);

} 

if(isset($_POST['date_ende']) && !empty(trim($_POST['date_ende']))){
  $date_ende = trim($_POST['date_ende']);

} 


if(isset($_POST['kategorie']) && !empty(trim($_POST['kategorie']))){
  $kategorie = trim($_POST['kategorie']);

 
  }
 


  
$date_anfang = date("d.m.Y, H:i ");

$userID = $_SESSION['id'] ?? 0;

$int = 1;
 
if (empty($error)) {

    

    // INPUT Query erstellen, welches firstname, lastname, username, password, email in die Datenbank schreibt
     $query = "Insert into task (titel, beschreibung, date_ende, prioritaet, id_kategorie, id_user) values(?,?,?,?,?,?)";
     
     // Query vorbereiten mit prepare();
     $stmt = $mysqli->prepare($query);
     if($stmt === false) {
 
       $error .= 'prepare() failed' . $mysqli->error . '<br />';
 
     }
    // Parameter an Query binden mit bind_param();
     if (!$stmt->bind_param('sssiii', $todo, $beschreibung, $date_ende, $prio, $int, $userID)) {
 
       $error .= 'bind_param() failed ' . $mysqli->error . '<br />';
     }
 
     //Query ausführen mit execute();
 
       if (!$stmt->execute()) {
         $error .= 'execute() failed' . $mysqli->error . '<br />';
 
       }
    
       // Verbindung schliessen
     $mysqli->close();
 

    if (isset($_POST['senden']))  {
     // Weiterleitung auf todo_liste.php
    
     header('Location: todo_liste.php');
    
     
      }

     

      
    }
    
?>

<!DOCTYPE html>
<html lang="en">
  <head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Todo erstellen</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../CSS/bootstrap.min.css">


    <script src="js/jquery1124/jquery.min.js"> </script>
    <script src="js/bootstrap.min.js"> </script>


    <!-- Datepicker -->
    <link rel="stylesheet" type="text/css" href="js/bootstrap-datepicker.css">
    <script src="js/bootstrap-datepicker.min.js"></script>
    <script src="js/bootstrap-datepicker.de.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  </head>
  <body>
 

<form action="" method ="post">
<div class="container">

<h1>Todo erstellen</h1>

    <label for="exampleInputEmail1">Priorität</label>
    <input type="textarea" class="form-control" id="exampleFormControlFile1" name="prio" aria-describedby="info" placeholder="1-5"
   pattern="[1-5]"
							title="Maximallänge überschritten"
							required="true">
    <small id="info" class="form-text text-muted">1 = Niedrigste, 5 = höchste.</small> 


  
    <br>
    <label for="exampleInputPassword1">Zu machen:</label>
    <input type="textarea" class="form-control" name="todo" id="exampleFormControlFile1" placeholder="Geben Sie den Titel an">
 
  
    <br>
    <label for="exampleInputPassword1">Beschreibung:</label>
    <textarea name = "textarea" class="form-control" name="beschreibung" id="exampleFormControlFile1" maxlength="255"> </textarea>

    <br>
    <label for="exampleInputPassword1">Kategorie:</label>
    <input type="text" class="form-control" name="kategorie" id="exampleFormControlFile1" placeholder="Geben Sie die Kategorie ein">


    <br>
    <div class="form-group date">
          <label for="inputEmail3" class="col-sm-2 control-label">Erledigt bis</label>
          <div class="col-sm-2">
            <input class="form-control" name="date_ende" data-provide="datepicker" data-date-format="yyyy-mm-dd" pattern="\d{4}-\d{1,2}-\d{1,2}" value="<?php echo date("Y-m-d"); ?>" name="date_ende">
          </div>
        </div>

<script>
          $(document).ready(function(){
            var date_input=$('input[name="date_ende"]'); // Die eingabe hat die sele name "date"
            var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
            date_input.datepicker({
                format: 'yyyy-mm-dd',
                weekStart: 1,
                container: container,
                todayHighlight: true,
                autoclose: true,
                daysOfWeekHighlighted: "1,2,3,4,5",
                calendarWeeks: true,
                language: "de"
            })
          })
        </script>

<br><br>


  <input type="submit" name="senden"/></button>



  



<tbody> 

</tbody>





</form>
  </body>
  </html>






