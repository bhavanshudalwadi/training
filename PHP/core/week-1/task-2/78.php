<?php
    function sub_string($s1) {
        if (strlen($s1) > 1) {
            return substr($s1, 0, strlen($s1) - 2) . substr($s1, strlen($s1) - 1, 1) . substr($s1, strlen($s1) - 2, 1);
        } else {
            return $s1;
        }
    }

    echo sub_string("Hello")."<br>";
    echo sub_string("Python")."<br>";
    echo sub_string("PHP")."<br>";
    echo sub_string("JS")."<br>";
    echo sub_string("C")."<br>";
?>
