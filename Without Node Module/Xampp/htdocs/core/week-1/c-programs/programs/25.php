<?php
    $num1 = 36;
    $num2 = 48;

    function calculateLCM($a, $b)
    {
        return abs($a * $b) / calculateGCD($a, $b);
    }

    function calculateGCD($a, $b)
    {
        while ($b != 0) {
            $temp = $b;
            $b = $a % $b;
            $a = $temp;
        }
        return $a;
    }

    $lcm = calculateLCM($num1, $num2);
    echo "LCM of $num1 and $num2 is: $lcm";
?>
