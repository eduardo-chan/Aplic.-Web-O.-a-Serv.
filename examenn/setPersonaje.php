<?php
    ini_set('display_errors', 1);
    $nombre = $_REQUEST["name"];
    $apellido = $_REQUEST["lastname"];
    $fdn = $_REQUEST["birthday"];
    $salario = $_REQUEST["utiliza_magia"];
    $posicion = $_REQUEST["estatura"];
    $genero = $_REQUEST["peso"];
    $genero = $_REQUEST["magia_id"];
    $genero = $_REQUEST["tipo_lucha_id"];

    if($name != "" && $lastname != "" && $birthday != "" && $utiliza_magia != "" && $estatura != "" && $peso != "" && $magia_id != ""
    && $tipo_lucha_id != ""){
        try{
            $pdo = new PDO("mysql:host=localhost;dbname=kof", "root", "root");
            $resultado = $pdo->prepare('INSERT INTO staff(name, lastname,
                                        birthday, utiliza_magia, estatura, peso,
                                        magia_id, tipo_lucha_id)
                                        VALUES(:a, :b, :c, :d, :e, :f, :g, :h)');
            $resultado->bindParam(":a", $name, PDO::PARAM_STR);
            $resultado->bindParam(":b", $lastname, PDO::PARAM_STR);
            $resultado->bindParam(":c", $birthday, PDO::PARAM_STR);
            $resultado->bindParam(":d", $utiliza_magia, PDO::PARAM_STR);
            $resultado->bindParam(":e", $estatura, PDO::PARAM_STR);
            $resultado->bindParam(":f", $peso, PDO::PARAM_STR);
            $resultado->bindParam(":g", $magia_id, PDO::PARAM_STR);
            $resultado->bindParam(":h", $tipo_lucha_id, PDO::PARAM_STR);
            $resultado->execute();
        } catch (PDOException $e) {
            echo $e-> getMessage();
        }    
    } else {
        echo "-1";
    }   
?>