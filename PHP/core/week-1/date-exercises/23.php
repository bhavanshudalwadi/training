<?php 
    $currentMonth = date("n");
    $previousMonths = [];
    for ($i = 3; $i > 0; $i--) {
        $previousMonths[] = date("Y-m", strtotime("-$i months"));
    }
    print_r($previousMonths);
?>
