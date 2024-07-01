<?php 
    $weekNumber = 12;
    $year = 2014;
    $startDate = new DateTime();
    $startDate->setISODate($year, $weekNumber, 1);
    $endDate = clone $startDate;
    $endDate->modify("+6 days");
    echo "Starting date of the week: " . $startDate->format("Y-m-d") . "<br>";
    echo "End date of the week: " . $endDate->format("Y-m-d");
?>
