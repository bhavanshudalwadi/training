<?php
    function sum($x, $y) {
        if ($x > 13 && $y > 13) return 0;
        
        if ($x <= 13 && $y > 13) return $x;
        
        if ($y <= 13 && $x > 13) return $y;
        
        return $x > $y ? $x : $y;
    }

    echo sum(4, 5)."<br>";
    echo sum(7, 12)."<br>";
    echo sum(10, 13)."<br>";
    echo sum(17, 33)."<br>";
?>
