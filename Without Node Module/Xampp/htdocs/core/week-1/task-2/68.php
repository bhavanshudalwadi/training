<?php
    function concat($s1) {
        return substr($s1, strlen($s1) - 2, 2) . substr($s1, 0, strlen($s1) - 2);
    }

    echo concat("Hello")."<br>";
    echo concat("JS")."<br>";
?>
