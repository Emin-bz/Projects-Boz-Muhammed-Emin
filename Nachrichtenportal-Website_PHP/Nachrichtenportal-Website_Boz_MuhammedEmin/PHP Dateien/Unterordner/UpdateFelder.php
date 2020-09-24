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
    
    <div class="headerAkt">
    <h1>Aktualisierung</h1>
    </div>

    <div class ="Boxen">     
    <form enctype="multipart/form-data" action="Verfassen.php" method ="post">
        
            
        <br> <br> <br>   
        <label for = "Dateiname"> Name der gewünschten Datei: <input type="text" name ="dateiname" required=required /> </label>
        Neuer Author: <input type ="text" name ="author" maxlength="50" required=required />
        <label for = "Titel" id = "TITEL"> Neuer Titel: </label>
        <input type ="text" name ="titel" maxlength="80" required=required /> 
       
        <br> <br><label for = "Nachricht"> Neue Nachricht: </label>
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

if (isset($_POST['speichern'])){
$Dateiname = $_POST['dateiname'];
$Author = $_POST['author']; 
$Titel = $_POST['titel'];
$Nachricht = $_POST['nachricht'];
$filename = "../../Textdateien/" . $Dateiname . ".txt"; 

if(file_exists($filename)) {

if (isset($_FILES['bild'])) {

$file = $_FILES['bild'];
$fileError = $_FILES['bild']['error'];
$fileName = $_FILES['bild']['name'];
$fileTmp = $_FILES['bild']['tmp_name'];
$fileSize = $_FILES['bild'] ['size'];
$fileType = $_FILES['bild']['type'];
    
    
// Hier wird überprüft, ob die Bildgrösse dafür geeignet ist die Textdatei zu speichern, damit entweder beide oder gar keine Datei gespeichert wird.
if (file_exists($filename)) { 
    if ($fileSize < 500000 && $fileError === 0) {
        if (strlen(isset($_POST['speichern']))) {

$Eigenschaften = date("d.m.Y, H:i ") . " | " . $Author . " | " . $Titel . " | " . $Nachricht;
file_put_contents($filename, $Eigenschaften);
        }

}
}
}
}

    
// Der Bild-Upload Teil

$Zielpfad = '../../Bilder/' . $Dateiname . '.jpg'; 
if(file_exists($Zielpfad)) { 
$fileEndung = explode('.', $fileName);
$fileVonHinten = strtolower(end($fileEndung));
    
$Erlaubt = array('jpg','jpeg', 'png', 'gif', 'svg');
    
if (file_exists($Zielpfad)) {
if (in_array($fileVonHinten, $Erlaubt)) {
    
    if ($fileError === 0) {
        
        if ($fileSize <= 500000) {
            
            
            
    move_uploaded_file($fileTmp, $Zielpfad);
    header("location: index.php?uploadsuccess");
    
        }
// Fehlermeldungen die bei überschreiten der Dateigrösse oder bei einem anderen Fehler erscheinen. 
else {
    
    echo "Datei ist zu gross";
    
}
        
} 
    else {
        echo "Es gab einen Fehler beim Hochladen.";
    }
}
}
    else {
        
        echo "Die Datei existiert nicht.";
    }
}
}

?>