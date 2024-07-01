<?php
    function concat($s1) {
        if (strlen($s1) < 2) {
            return $s1;
        }else {
            return substr($s1, 0, 2);
        }
    }

    echo concat("Hello")."<br>";
    echo concat("Hi")."<br>";
    echo concat("H")."<br>";
    echo concat("  ")."<br>";
?>
