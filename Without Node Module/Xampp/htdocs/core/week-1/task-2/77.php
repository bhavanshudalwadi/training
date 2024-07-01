<?php
    function sub_string($s1, $s2) {
        if (strlen($s1) < 1) {
            return $s2;
        }

        if (strlen($s2) < 1) {
            return $s1;
        }

        if (substr($s1, strlen($s1) - 1, 1) <> substr($s2, 0, 1)) {
            return $s1 . $s2;
        } else {
            return $s1 . substr($s2, 1, strlen($s1) - 1);
        }
    }

    echo sub_string("abc", "cat")."<br>";
    echo sub_string("Python", "PHP")."<br>";
    echo sub_string("php", "php")."<br>";
?>
