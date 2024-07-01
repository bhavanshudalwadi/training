<?php
    function sum($val1, $val2, $val3) {
        return $val1 == $val2?$val3:($val2 == $val3?$val1:(($val1 == $val3)?$val2:$val1+$val2+$val3));
    }

    echo sum(4, 5, 7)."<br>";
    echo sum(7, 4, 12)."<br>";
    echo sum(10, 10, 12)."<br>";
    echo sum(12, 12, 18)."<br>";
?>