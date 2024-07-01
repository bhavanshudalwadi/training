<?php
    header("Content-Type: application/json");
    date_default_timezone_set('Asia/Calcutta');

    $host = "localhost";
    $user = "root";
    $pass = "";
    $database = "ecom_app";

    $con = mysqli_connect($host, $user, $pass, $database);

    if (!$con) {
        die("Connection failed: " . mysqli_connect_error());
    }

    function filter_data(&$inputs) {
        global $con;
        foreach ($inputs as $key => $value) {
            $inputs[$key] = trim($value);
            $inputs[$key] = mysqli_real_escape_string($con, $value);
        }
    }

    function is_already_exist($table_name, $column, $input) {
        global $con;

        $qry = "SELECT $column from $table_name where $column = '$input'";
        $result = mysqli_query($con, $qry);
        if(!$result) {
            die("Invalid parameters in is_already_exist()");
        }

        if(mysqli_num_rows($result) > 0) {
            return true;
        }else {
            return false;
        }
    }
?>