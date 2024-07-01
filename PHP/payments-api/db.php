<?php
    header("Content-Type: application/json");
    date_default_timezone_set('Asia/Calcutta');

    $host = "localhost";
    $user = "root";
    $pass = "";
    $database = "payments";

    $con = mysqli_connect($host, $user, $pass, $database);

    if (!$con) {
        die("Connection failed: " . mysqli_connect_error());
    }

    function filter_data($input) {
        $input = trim($input);
        $input = mysqli_real_escape_string($con, $input);
        return  $input != ''?$input:null;
    }
?>