<?php
    $a = 10;
    $b = 20;

    echo "Before Swap: a = $a, b = $b";

    swap($a, $b);

    echo "<br>After Swap: a = $a, b = $b";

    function swap(&$a, &$b) {
        $temp = $a;
        $a = $b;
        $b = $temp;
    }
?>