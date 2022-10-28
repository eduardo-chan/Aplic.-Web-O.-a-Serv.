<?php
if ($_POST) {
    $nombre = $_REQUEST["name"];
    $apellido = $_REQUEST["lastname"];
    $fdn = $_REQUEST["birthday"];
    $salario = $_REQUEST["utiliza_magia"];
    $posicion = $_REQUEST["estatura"];
    $genero = $_REQUEST["peso"];
    $genero = $_REQUEST["magia_id"];
    $genero = $_REQUEST["tipo_lucha_id"];

    if ($name != "" && $lastname != "" && $birthday != "" && $utiliza_magia != "" && $estatura != "" && $peso != "" && $magia_id != ""
    && $tipo_lucha_id != "") {
        try {
            $pdo = new PDO("mysql:host=localhost;dbname=utez","root","");
            $resultado = $pdo -> prepare('UPDATE personal SET nombre = :a,
            apellidoP = :b,apellidoM = :c,sueldo = :d, puesto = :e,fechaNac = :f 
            WHERE id = :g');
            $resultado->bindParam(":a", $nombre, PDO::PARAM_STR);
            $resultado->bindParam(":b", $apellidoP, PDO::PARAM_STR);
            $resultado->bindParam(":c", $apellidoM, PDO::PARAM_STR);
            $resultado->bindParam(":d", $sueldo, PDO::PARAM_INT);
            $resultado->bindParam(":e", $puesto, PDO::PARAM_INT);
            $resultado->bindParam(":f", $fechaNac, PDO::PARAM_STR);
            $resultado->bindParam(":g", $id, PDO::PARAM_INT);
            $resultado->bindParam(":h", $id, PDO::PARAM_INT);
            $resultado -> execute();
            echo "Actualizado con exito.";
        } catch (PDOException $e) {
            echo $e -> getMessage();
        }
    }else{
        echo "-1";
    }
}
?>
