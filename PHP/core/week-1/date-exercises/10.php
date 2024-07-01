<?php 
    $dates = ["2024-03-05", "2024-13-40", "2024-02-29"];
    foreach ($dates as $date) {
        $isValid = DateTime::createFromFormat("Y-m-d", $date) !== false;
        echo "$date is " . ($isValid ? "valid" : "invalid") . "<br>";
    }
?>
