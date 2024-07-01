<?php
    function concat($s1, $n) { 
        return substr($s1, 0, $n) . substr($s1, strlen($s1) - $n, $n);
    }

    echo concat("Hello", 1)."<br>";
    echo concat("Python", 2)."<br>";
    echo concat("on", 1)."<br>";
    echo concat("o", 1)."<br>";
?>
