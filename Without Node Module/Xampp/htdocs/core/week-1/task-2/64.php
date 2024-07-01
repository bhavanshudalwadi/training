<?php
    function concat($s1) {
        return substr(substr($s1, 1, strlen($s1) - 1), 0, strlen($s1) - 2);
    }

    echo concat("Hello")."<br>";
    echo concat("Hi")."<br>";
    echo concat("Python")."<br>";
?>
