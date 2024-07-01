<?php
    function sumOfDigits($number) {
        $digits = str_split($number);
        return array_sum($digits);
    }

    $testNumber = 12345;

    $sum = sumOfDigits($testNumber);

    echo "The sum of digits of $testNumber is: $sum";
?>