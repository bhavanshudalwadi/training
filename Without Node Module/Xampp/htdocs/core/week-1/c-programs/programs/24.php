<?php
    $num1 = 36;
    $num2 = 48;

    function calculateGCD($a, $b)
    {
        while ($b != 0) {
            $temp = $b;
            $b = $a % $b;
            $a = $temp;
        }
        return $a;
    }

    $gcd = calculateGCD($num1, $num2);
    echo "GCD of $num1 and $num2 is: $gcd";
?>
