<?php

$host = 'localhost';
$username = 'EminBoz';
$password = 'Emin123.';
$database = 'users';


$mysqli = new mysqli($host, $username, $password, $database);


if ($mysqli->connect_error) {

die('Connect Error (' . $mysqli->connect_error . ') ' . $mysqli->connect_error);
}




?>