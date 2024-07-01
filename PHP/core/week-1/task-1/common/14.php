<?php
    function isPrime($number) {
        for ($i = 2; $i < $number; $i++) {
            if ($number % $i === 0) {
                return false;
            }
        }

        return true;
    }

    $sum = 0;

    for ($i = 2; $i < 200; $i++) {
        if (isPrime($i)) {
            $sum += $i;
        }
    }

    echo "Sum: $sum";
?>