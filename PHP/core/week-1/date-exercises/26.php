<?php 
    $monthNumber = 3;
    $monthName = date("F", mktime(0, 0, 0, $monthNumber, 1));
    echo "Month $monthNumber is $monthName";
?>
