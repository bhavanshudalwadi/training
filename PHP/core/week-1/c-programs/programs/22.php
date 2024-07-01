<?php
    $num = 28;
    $sum = 0;

    for ($i = 1; $i <= $num / 2; $i++) {
        if ($num % $i == 0) {
            $sum += $i;
        }
    }

    if ($sum == $num) {
        echo "$num is a perfect number.";
    } else {
        echo "$num is not a perfect number.";
    }
?>
