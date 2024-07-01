<?php
    require_once("db.php");
    
    $data = [];
    if ($_SERVER['REQUEST_METHOD'] == "POST") {
        $_POST = json_decode(file_get_contents('php://input'), true);

        extract($_POST);

        if(isset($amount) && isset($from_upi) && isset($ref_no) && is_numeric($amount) && strlen($ref_no) == 12) {
            $qry = "insert into transactions(amount, from_upi, ref_no) values($amount, '$from_upi', '$ref_no')";
            if(mysqli_query($con, $qry)) {
                array_push($data, ["success" => true, "msg"=> "Payment Added Successful"]);
            }
        }else {
            array_push($data, ["success" => false, "msg"=> "Invalid Parameters"]);
        }
    }else {
        array_push($data, ["success" => false, "msg"=> "Method ".$_SERVER['REQUEST_METHOD']." is Not Supported"]);
    }
    echo json_encode($data);
?>