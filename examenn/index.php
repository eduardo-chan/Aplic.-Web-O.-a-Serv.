<?php
header('Content-Type: application/json');
$metodo = $_SERVER['REQUEST_METHOD'];
switch ($metodo) {
    case 'GET':
        //consulta
        if ($_GET['accion'] == 'personaje'){
            try{
                $conexion = new PDO("mysql:host=localhost;dbname=kof;charset=utf8","root","root");

            } catch (PDOException $e){
                echo $e->getMessage();
            }

            if(isset($_GET['id'])) {
                $pstm = $conexion->prepare('SELECT * from personaje');
                $pstm -> bindParam(':n', $_GET['id']);
                $pstm->execute();
                $rs=$pstm->fetchAll(PDO::FETCH_ASSOC);
                if($rs !=null){
                    echo json_encode($rs[0], JSON_PRETTY_PRINT);
                } else {
                    echo "ERROR...personaje no encontrado";    
                }
            } else {


                $pstm = $conexion->prepare('SELECT P.*,po.magia,po.tipo_lucha 
                FROM personaje p INNER JOIN magia po ON p.magia_id = po.id;');
                $pstm->execute();
                $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
                echo json_encode($rs, JSON_PRETTY_PRINT);
            }
        }


        if ($_GET['accion'] == 'magia'){
            try{
                $conexion = new PDO("mysql:host=localhost;dbname=kof;charset=utf8","root","root");

            } catch (PDOException $e){
                echo $e->getMessage();
            }

            if(isset($_GET['id'])) {
                $pstm = $conexion->prepare('SELECT * from personaje');
                $pstm -> bindParam(':n', $_GET['id']);
                $pstm->execute();
                $rs=$pstm->fetchAll(PDO::FETCH_ASSOC);
                if($rs !=null){
                    echo json_encode($rs[0], JSON_PRETTY_PRINT);
                } else {
                    echo "ERROR...personaje no encontrado";    
                }
            } else {
                echo "No se, error???";
            }
        }


        if ($_GET['accion'] == 'tipo_lucha'){
            try{
                $conexion = new PDO("mysql:host=localhost;dbname=kof;charset=utf8","root","root");

            } catch (PDOException $e){
                echo $e->getMessage();
            }

            if(isset($_GET['id'])) {
                $pstm = $conexion->prepare('SELECT * from personaje');
                $pstm -> bindParam(':n', $_GET['id']);
                $pstm->execute();
                $rs=$pstm->fetchAll(PDO::FETCH_ASSOC);
                if($rs !=null){
                    echo json_encode($rs[0], JSON_PRETTY_PRINT);
                } else {
                    echo "ERROR...personaje no encontrado";    
                }
            } else {
                echo "No se, error???";
            }
        }
        exit();
        break;


    case 'POST':
        if ($_GET['accion'] == 'personaje'){
            $jsonData = json_decode(file_get_contents("php://input"));
            try{
                $conexion = new PDO("mysql:host=localhost;dbname=kof;charset=utf8","root","root");

            } catch (PDOException $e){
                echo $e->getMessage();
            }
            $query = $conn->prepare('INSERT INTO personaje(id, name, lastname, birthday, utiliza_magia, estatura, peso, equipo, magia_id, tipo_lucha_id)
            VALUES (:name, :lastname, :birthday, :utiliza_magia, :estatura, :peso, :equipo, :magia:id, :tipo_lucha_id)');
            $query->bindParam(":name", $jsonData->name);
            $query->bindParam(":lastname", $jsonData->name);
            $query->bindParam(":birthday", $jsonData->name);
            $query->bindParam(":utiliza_magia", $jsonData->name);
            $query->bindParam(":estatura", $jsonData->name);
            $query->bindParam(":peso", $jsonData->name);
            $query->bindParam(":equipo", $jsonData->name);
            $query->bindParam(":magia_id", $jsonData->name);
            $query->bindParam(":tipo_lucha_id", $jsonData->name);
            $result = $query->execute();
            if($result){
                $_POST["error"] = false;
                $_POST["message"] = "Registrado correctamente :D";
                $_POST["status"] = 200;
            } else {
                $_POST["error"] = true;
                $_POST["message"] = "ERROR...";
                $_POST["status"] = 400;
            }
            echo json_encode(($_POST));
        }
        //magia, tipo_lucha ????????????????????
        break;
    case 'PUT':
        if ($_GET['accion'] == 'personaje'){
            $jsonData = json_decode(file_get_contents("php://input"));
            try{
                $conexion = new PDO("mysql:host=localhost;dbname=kof;charset=utf8","root","root");

            } catch (PDOException $e){
                echo $e->getMessage();
            }
            $query = $conn->prepare("UPDATE `pesonaje` SET `name` = :name, `lastname` = :lastname, `birthday` = :birthday, `utiliza_magia` = :utiliza_magia,
            ,`estatura` = :estatura, `peso` = :peso, `equipo` = :equipo, `magia_id` = :magia_id, `tipo_lucha_id` = :tipo_lucha_id,
            WHERE `id` = :id");

            $query->bindParam(":name", $jsonData->name);
            $query->bindParam(":lastname", $jsonData->name);
            $query->bindParam(":birthday", $jsonData->name);
            $query->bindParam(":utiliza_magia", $jsonData->name);
            $query->bindParam(":estatura", $jsonData->name);
            $query->bindParam(":peso", $jsonData->name);
            $query->bindParam(":equipo", $jsonData->name);
            $query->bindParam(":magia_id", $jsonData->name);
            $query->bindParam(":tipo_lucha_id", $jsonData->name);
            $query->bindParam(":id", $jsonData->id);
            $result = $query->execute();
            if($result){
                echo ("Registro correcto :D Code $result");
            } else {
                echo ("ERROR... Code $result");
            }
        }
        break;
        case 'DELETE':
            if ($_GET['accion'] == 'personaje') {
                $id = $_GET['id'];
                try {
                    $conn = new PDO("mysql:host=localhost;dbname=kof;charset=utf8", "root", "root");
                } catch (PDOException $e) {
                    echo $e->getMessage();
                }
                $query = "DELETE FROM personaje WHERE id = :id";
                $pstm = $conn->prepare($query);
                $pstm->bindParam(":id", $id);
                $rs = $pstm->execute();
                if ($rs) {
                    echo ("Personal eliminado correctamente. Code $rs");
                } else {
                    echo ("Error al eliminar a este personal. Code $rs");
                }
            }
            break;
        default:
            echo "Método no soportado.";
            break;
}







