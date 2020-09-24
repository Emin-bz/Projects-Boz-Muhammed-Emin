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
        <h1>Verfassen</h1>
        </div>
        <div class="topnav">
        <a href=index.php>Home</a>
        <a href=Verfassen.php>Verfassen</a>
        <a href=DateienAnzeigen.php>Dateien Verwalten</a>
        </div>
        <div class ="Boxen">     
        <form enctype="multipart/form-data" action="Verfassen.php" method ="post">
           
        <br> <br> <br>   
        <label for = "Dateiname"> Dateiname: <input type="text" name ="dateiname" required=required /> </label>
        Author: <input type ="text" name ="author" maxlength="50" required=required />
        <label for = "Titel" id = "TITEL"> Titel: </label>
        <input type ="text" name ="titel" maxlength="80" required=required /> 
         
        <br> <br><label for = "Nachricht"> Nachricht: </label>
        <br> <br><textarea name = "nachricht" maxlength = "2000" cols = "30" rows = "10" required=required ></textarea> 
        
        <input type="hidden" name="MaxSize" value="500000"/>
        <input type="file" name="bild" required=required />
        <div class = "myButton">
        <br><input type="submit" name="speichern" value="Senden"/>
        </div>
            
        
</form> 
</div>
</body>
</html>


<?php

//------------------------------------------------php code----------------------------------------------------------------

// Es wird überprüft, ob die Bilddatei gesetzt wurde.

if (isset($_FILES['bild'])) {

$file = $_FILES['bild'];
$fileError = $_FILES['bild']['error'];
$fileName = $_FILES['bild']['name'];
$fileTmp = $_FILES['bild']['tmp_name'];
$fileSize = $_FILES['bild'] ['size'];
$fileType = $_FILES['bild']['type'];
    
    
// Hier wird überprüft, ob der submit Knopf gedrückt wurde.

if (isset($_POST['speichern'])){
$Dateiname = $_POST['dateiname'];
$Author = $_POST['author']; 
$Titel = $_POST['titel'];
$Nachricht = $_POST['nachricht'];


    if ($fileSize < 500000 && $fileError === 0) {
        if (strlen(isset($_POST['speichern']))) {
$filename = "../Textdateien/" . $Dateiname . ".txt"; 
$Eigenschaften = date("d.m.Y, H:i ") . " | " . $Author . " | " . $Titel . " | " . $Nachricht;
file_put_contents($filename, $Eigenschaften);
        }

}
}
    
// Der Bild-Upload Teil 
    
$fileEndung = explode('.', $fileName);
$fileVonHinten = strtolower(end($fileEndung));
    
$Erlaubt [0] = "jpg";
$Erlaubt [1] = "png";
$Erlaubt [2] = "jpeg";
$Erlaubt [3] = "gif";
$Erlaubt [4] = "svg";
    
    
if (in_array($fileVonHinten, $Erlaubt)) {
    
    if ($fileError === 0) {
        
        if ($fileSize < 500000) {
            
            $Zielpfad = '../Bilder/' . $Dateiname . '.jpg';
            
            move_uploaded_file($fileTmp, $Zielpfad);
            header("Location: index.php?uploadsuccess");
        }
// Fehlermeldungen die bei überschreiten der Dateigrösse oder bei einem anderen Fehler erscheinen. 
        
else {
    
    echo "<div class = Fehlermeldungen>";
    echo "Datei ist zu gross";
    echo "</div>";
}      
}
    else {
        echo "<div class = Fehlermeldungen>";
        echo "Die Datei konnte aufgrund eines Fehlers nicht hochgeladen werden.";
        echo "</div>";
    }
}
}

?>