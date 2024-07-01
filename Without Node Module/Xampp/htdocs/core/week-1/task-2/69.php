<?php
    function concat($s1) {
        return strlen($s1) < 2 ? "" : substr($s1, 1, strlen($s1) - 2);
    }

    echo concat("Hello")."<br>";
    echo concat("JS")."<br>";
    echo concat("  ")."<br>";
?>
