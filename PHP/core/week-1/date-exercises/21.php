<?php 
    $seconds = 200000;
    $days = floor($seconds / (24 * 60 * 60));
    $hours = floor(($seconds % (24 * 60 * 60)) / (60 * 60));
    $minutes = floor(($seconds % (60 * 60)) / 60);
    $remainingSeconds = $seconds % 60;
    echo "$days days, $hours hours, $minutes minutes, and $remainingSeconds seconds";
?>
