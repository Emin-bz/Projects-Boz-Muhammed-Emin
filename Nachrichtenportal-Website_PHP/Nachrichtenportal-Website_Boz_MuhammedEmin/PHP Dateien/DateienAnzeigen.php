<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="../CSS%20Dateien/style.css" media="screen" />
<html>

<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Nachrichtenformular</title>
        <meta name="description" content="Formular">
        <link rel="stylesheet" href="main.css">
</head>
<body>   
    
        <div class="header">
        <h1>Dateien Anzeigen</h1>
        </div>
        <div class="topnav">
        <a href=index.php>Home</a>
        <a href=Verfassen.php>Verfassen</a>
        <a href=DateienAnzeigen.php>Dateien Verwalten</a>
        </div>
        <form action = "DateienAnzeigen.php" method = "post" >
        
        <div class = "Elemente">    
       <br> <br> Löschen: <input type = "text" name = "loeschen" id = "Loeschen" />
       <input type = "submit" name = "del" value = "Löschen" id = "Del" />
       <br> <br> <br> <input type = "submit" name = "upd" value = "Aktualisieren" id = "Upd" />
       </div>
            
            
</form> 
</body>
</html>

<?php

//------------------------------------------------php code----------------------------------------------------------------

$filename = "../";
$filename2 = "Textdateien";
$filename3 = "/*";
$endung = ".txt";

// Befehle zur Aktualisierung der Dateien

$UpdateFile = '../Textdateien/*.txt';
if (isset($_POST['upd'])) {
    
    
    require("Unterordner/UpdateFelder.php");
    
}

// Die Ausgabe von Dateien die im Verzeichnis existieren, die zur Verwaltung benutzt werden können (Löschen und Aktualisieren).

foreach (glob($filename . $filename2 . $filename3 . $endung) as $fname) {
    
    echo "<div class = AnzeigeDateien>";
    echo "<br>" . "<h2>" . $fname . "<br>";
    echo "</div>";
    
}

// Die Befehle zum Löschen von Textdateien und den dazugehörigen Bildern

if (isset($_POST['del'])) {
    
    $Loeschen = $_POST['loeschen'];
    
    $DeleteFile = '../Textdateien/' . $Loeschen . '.txt'; 
    $DeleteImg = '../Bilder/' . $Loeschen . '.jpg';

    
if(file_exists($DeleteFile)) {
  
    unlink($DeleteFile);
    header("location: index.php?uploadsuccess");
    
        if(file_exists($DeleteImg)) {
        
            unlink($DeleteImg);
            header("location: index.php?uploadsuccess");
    }
}
    
}
 
?>