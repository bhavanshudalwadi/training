<?php
    header("Content-Type: application/json");

    $host = "localhost";
    $user = "root";
    $pass = "";
    $database = "kmk";

    $con = mysqli_connect($host, $user, $pass, $database);

    $qry = "select * from registrations";

    $result = mysqli_query($con, $qry);

    if (mysqli_num_rows($result) > 0) {
        $arr = [];
        while ($row = mysqli_fetch_assoc($result)) {
            array_push($arr, $row);
        }

        $jsonString = json_encode($arr);
    
        $filePath = 'registrations.json';
        
        $file = fopen($filePath, 'w');
        if ($file) {
            fwrite($file, $jsonString);
            fclose($file);
            echo 'JSON file created successfully.';
        } else {
            echo 'Unable to create JSON file.';
        }
    }

?>
