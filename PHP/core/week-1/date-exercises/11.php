<?php 
    $date1 = new DateTime("2022-01-01");
    $date2 = new DateTime("2024-03-05");
    $interval = $date1->diff($date2);
    echo "Difference: " . $interval->format("%y years, %m months, %d days, %h hours, %i minutes, %s seconds");
?>
