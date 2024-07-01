<?php
    function sum($x, $y) {
        return strlen((string)($x + $y)) > strlen((string)$x) ? $x : $x + $y;
    }

    echo sum(4, 5)." <br>";
    echo sum(7, 4)." <br>";
    echo sum(10, 10)." <br>";
?>