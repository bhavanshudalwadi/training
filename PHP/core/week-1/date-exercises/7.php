<?php 
    $date1 = new DateTime("12-05-2014");
    $date2 = new DateTime("now");
    $interval = $date1->diff($date2);
    echo $interval->days;
?>
