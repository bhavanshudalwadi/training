<?php 
    $originalDate = new DateTime("2012-12-21");
    $modifiedDate = clone $originalDate;
    $modifiedDate->modify("+1 month");
    echo "Original date: " . $originalDate->format("Y-m-d") . "<br>";
    echo "After one month: " . $modifiedDate->format("Y-m-d");
?>
