<?php 
    $date = new DateTime("2014-03-15");
    echo "First day: " . $date->format("Y-m-01") . "<br>";
    echo "Last day: " . $date->format("Y-m-t");
?>
