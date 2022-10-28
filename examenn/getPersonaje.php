<?php
try {
    $pdo = new PDO("mysql:host=localhost;dbname=kof","root","root");
} catch (PDOException $e) {
    echo $e ->getMessage();
}

$sql = "SELECT * FROM personaje";
$resultado = $pdo->query($sql);
$datos=array();

while ($row = $resultado->fetch(PDO::FETCH_ASSOC)) {
    $datos[]=$row;
}
echo json_encode($datos);
?>   