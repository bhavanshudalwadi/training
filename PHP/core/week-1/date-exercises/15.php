<?php 
    $date = new DateTime("2024-03-06");
    $isWeekend = ($date->format("N") >= 6);
    echo $isWeekend ? "It's a weekend" : "Its not a weekend";
?>
