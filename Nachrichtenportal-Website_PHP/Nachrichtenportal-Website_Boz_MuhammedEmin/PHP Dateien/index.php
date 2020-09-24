<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="../CSS%20Dateien/style.css" media="screen"/>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Nachrichtenformular</title>
        <meta name="description" content="Formular">
        <link rel="stylesheet" href="style.css">
</head>
<body>   
    
        <div class="header">
        <h1>Home</h1>
        </div>
        <div class="topnav">
        <a href=index.php>Home</a>
        <a href=Verfassen.php>Verfassen</a>
        <a href=DateienAnzeigen.php>Dateien Verwalten</a>
        </div>
        <form action = "index.php" method = "get" >
                
</form> 
</body>
</html>


<?php

//------------------------------------------------ php Code --------------------------------------------------------------

// Überprüfungen ob die die Elemente gesetzt wurden, wenn ja dann werden sie einer Variable zugewiesen.

if (isset ($_POST['dateiname'])) {
    $Dateiname = $_POST['dateiname'];
}

if (isset ($_POST['author'])) {
    $Author = $_POST['author'];
}

if (isset ($_POST['titel'])) {
$Titel = $_POST['titel'];
}

if (isset($_POST['nachricht'])) {
$Nachricht = $_POST['nachricht'];
}

if (isset($_POST['submit'])) {
$Submit = $_POST['submit'];
}

//---------------------------------------------- Nachrichtenportal -------------------------------------------------------

//Ausgeben der Dateien und Bilder dazu im Home
foreach (glob("../Textdateien/*.txt") as $fname) {
    
    $Pfad = "../Bilder/";
    $bildoutput = explode("/", $fname);
    $Bildname = explode (".", $bildoutput[2]);
    $ganzeBildname = $Pfad . $Bildname[0] . ".jpg";
    
    echo '<div class="Homebox">';
    $output = file_get_contents($fname);
    $Explode = explode("|", $output);
    $Datum = $Explode[0];
    $Author = $Explode[1];
    $Titel = $Explode[2];
    $Nachricht = $Explode[3];
    
    echo "<h4>" . "<br>" . $Datum . "<h3>" . "<br>" . "Von: " . $Author . "<h2>" . "<br>" . "Titel: " . $Titel;
    
    
    echo '<div class = "Bild">';
    echo "<br>" . '<img src="'.$ganzeBildname.'" alt="" height="200" width="200">';
    echo "</div>";
    
    echo "<h2>" . "Nachricht:";
    
    echo "<div class = NachrichtBorder>";
    echo "<h2>" . "<br>" . $Nachricht;
    echo "</div>";
    
    echo "</div>";
    
}

?>