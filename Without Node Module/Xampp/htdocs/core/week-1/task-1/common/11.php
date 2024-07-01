<?php
    function isArmstrong($number) {
        $numDigits = strlen((string)$number);
        $temp = $number;
        $sum = 0;

        while ($temp > 0) {
            $digit = $temp % 10;
            $sum += pow($digit, $numDigits);
            $temp = (int)($temp / 10);
        }

        return $sum == $number;
    }
    // 1^3 = 1 + 5^3 = 125 + 3^3 = 27 = 153;

    $testNumber = 153;

    if (isArmstrong($testNumber)) {
        echo "$testNumber is an Armstrong number.";
    } else {
        echo "$testNumber is not an Armstrong number.";
    }
?>