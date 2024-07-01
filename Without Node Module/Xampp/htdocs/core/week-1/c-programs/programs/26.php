<?php
    $num = 24;

    function calculateFactorial($n) {
        $result = 1;
        for ($i = 1; $i <= $n; $i++) {
            $result *= $i;
        }
        return $result;
    }

    $factors = calculateFactorial($num);
    echo "Factorial of $num is: $factors";
?>
