<?php
    function test($x, $y) {
        if ($x == $y) {
            return 0;
        }else if (($x % 7 == $y % 7) || $x < $y) {
            return $x;
        } else {
            return $y;
        }
    }

    echo test(11, 21)."<br>";
    echo test(9, 20)."<br>";
    echo test(10, 10)."<br>";
?>
