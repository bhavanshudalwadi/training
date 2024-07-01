<?php
    require_once("db.php");
    
    $data = [];
    if ($_SERVER['REQUEST_METHOD'] == "DELETE") {
        $id = $_GET["id"];

        if(isset($id) && is_numeric($id) && $id != '') {
            $qry = "delete from transactions where id = $id";
            if(mysqli_query($con, $qry)) {
                array_push($data, ["success" => true, "msg"=> "Payment Deleted Successful"]);
            }
        }else {
            array_push($data, ["success" => false, "msg"=> "Invalid Parameters"]);
        }
    }else {
        array_push($data, ["success" => false, "msg"=> "Method ".$_SERVER['REQUEST_METHOD']." is Not Supported"]);
    }
    echo json_encode($data);
?>