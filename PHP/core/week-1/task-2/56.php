<?php
    function sum($x, $y, $z) {
        return fix_num($x) + fix_num($y) + fix_num($z);
    }
    function fix_num($n) {
        // return (array_search($n, range(9, 13)) != false || array_search($n, range(17, 21)) != false) ? 0 : $n;
        return (($n < 13 && $n > 9) || ($n > 17 && $n < 21)) ? 0 : $n;
    }

    echo sum(4, 5, 7)."<br>";
    echo sum(7, 4, 12)."<br>";
    echo sum(10, 13, 12)."<br>";
    echo sum(17, 12, 18)."<br>";
?>