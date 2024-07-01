<?php
    header("Content-Type: application/json");

    $host = "localhost";
    $user = "root";
    $pass = "";
    $database = "kmk";

    $con = mysqli_connect($host, $user, $pass, $database);

    $qry = "select * from registrations";

    $result = mysqli_query($con, $qry);

    $arr = [];
    if (mysqli_num_rows($result) > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            array_push($arr, $row);
        }
    }else{
        array_push($arr, ["msg" => "No Records Found"]);
    }
    
    echo json_encode($arr);
?>
