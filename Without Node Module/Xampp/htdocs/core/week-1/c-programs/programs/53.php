<?php
    function calculateGCD($a, $b) {
        while ($b != 0) {
            $temp = $b;
            $b = $a % $b;
            $a = $temp;
        }
        return $a;
    }

    function calculateLCM($a, $b) {
        return abs($a * $b) / calculateGCD($a, $b);
    }

    $array = [36, 48, 60];
    $gcd = $array[0];
    $lcm = $array[0];

    foreach ($array as $element) {
        $gcd = calculateGCD($gcd, $element);
        $lcm = calculateLCM($lcm, $element);
    }

    echo "GCD of the array elements: $gcd<br>";
    echo "LCM of the array elements: $lcm";
?>
