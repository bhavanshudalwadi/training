<?php
    function concat($s1, $s2) { 
        return substr($s1, 1, strlen($s1) - 1) . substr($s2, 1, strlen($s2) - 1);
    }

    echo concat("Hello", "Hi")."<br>";
    echo concat("JS", "Python")."<br>";
?>
