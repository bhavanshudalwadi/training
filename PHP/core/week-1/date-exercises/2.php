<?php
    $dob = "2024-11-08";

    $date = date("Y-m-d");

    // 60 min * 24 hours = 1 Day
    // 60 * 60 * 24

    $days = floor((strtotime($dob) - strtotime($date)) / (60 * 60 * 24));

    echo "Your Birthday is After ".$days." Days";
?>
