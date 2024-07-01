<?php
    function test($x, $y, $z) {
        if ($x > $y && $x > $z && $y > $z) return $x - $y == $y - $z;
        
        if ($x > $y && $x > $z && $z > $y) return $x - $z == $z - $y;
        
        if ($y > $x && $y > $z && $x > $z) return $y - $x == $x - $z;
        
        if ($y > $x && $y > $z && $z > $x) return $y - $z == $z - $x;
        
        if ($z > $x && $z > $y && $x > $y) return $z - $x == $x - $y;
        
        return $z - $y == $y - $x;
    }

    var_dump(test(4, 5, 6));
    var_dump(test(7, 12, 13));
    var_dump(test(-1, 0, 1));
?>
