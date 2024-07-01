<?php
    function concat($s1) { 
        return substr($s1, strlen($s1)/2 - 1, 2); 
    }

    echo concat("Hell")."<br>";
    echo concat("JS")."<br>";
    echo concat("  ")."<br>";
?>
