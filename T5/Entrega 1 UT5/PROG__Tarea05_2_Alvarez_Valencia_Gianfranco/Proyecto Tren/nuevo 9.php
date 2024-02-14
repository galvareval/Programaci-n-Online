<?php
//getting the database connection
include 'conn.php';
$nombre=$_POST['nombre'];
$apellidos=$_POST['apellidos'];
$correo=$_POST['correo'];
$telefono=$_POST['telefono'];
$descripcion=$_POST['descripcion'];
$update="UPDATE usuario SET  nombre='".$nombre."', apellidos='".$apellidos."', telefono ='".$telefono."', descripcion ='".$descripcion."' WHERE correo ='".$correo."'";

mysqli_query($conn,$update) or die (mysqli_error());
mysqli_close($conn);


?>