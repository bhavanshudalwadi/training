<?php 
    $currentMonth = date("n");
    $last6Months = [];
    for ($i = 6; $i > 0; $i--) {
        $last6Months[] = date("Y-m", strtotime("-$i months"));
    }
    print_r($last6Months);
?>
