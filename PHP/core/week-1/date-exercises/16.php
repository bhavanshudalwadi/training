<?php 
    $originalDate = new DateTime("2011-01-01");
    $beforeDays = 40;
    $afterDays = 40;
    echo "Original date: " . $originalDate->format("Y-m-d") . "<br>";
    echo "Before $beforeDays days: " . $originalDate->modify("-$beforeDays days")->format("Y-m-d") . "<br>";
    echo "After $afterDays days: " . $originalDate->modify("$afterDays days")->format("Y-m-d");
?>
