<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $database = "kmk";

    $con = mysqli_connect($servername, $username, $password, $database);

    if (!$con) {
        die("Connection failed: " . mysqli_connect_error());
    }

    date_default_timezone_set('Asia/Calcutta');

    $app_url = "http://localhost/registration-form";

    function filter_data($input) {
        $input = trim($input);
        return  $input != ''?$input:null;
    }

    function generate_password() {
        $alphabet = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890';
        $pass = array();
        $alphaLength = strlen($alphabet) - 1;
        for ($i = 0; $i < 8; $i++) {
            $n = rand(0, $alphaLength);
            $pass[] = $alphabet[$n];
        }
        return implode($pass);
    }
?>