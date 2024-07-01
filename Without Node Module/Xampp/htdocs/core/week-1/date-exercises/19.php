<?php 
    $date1 = new DateTime("2014-01-01");
    $date2 = new DateTime("2014-12-31");
    $interval = $date1->diff($date2);
    echo "Weeks between " . $date1->format("m/d/Y") . " and " . $date2->format("m/d/Y") . " is " . floor($interval->days / 7);
?>
