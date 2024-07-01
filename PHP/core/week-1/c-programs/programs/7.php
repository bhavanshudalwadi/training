<?php
    $n = 10;
    $a = 0;
    $b = 1;

    echo "Fibonacci Series up to $n terms: ";

    for ($i = 1; $i <= $n; $i++) {
        echo $a . ", ";
        $temp = $a + $b;
        $a = $b;
        $b = $temp;
    }
?>