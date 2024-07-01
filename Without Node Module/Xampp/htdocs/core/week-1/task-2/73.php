<?php
    function sub_string($s1, $index) {
        return $index + 2 <= strlen($s1) ? substr($s1, $index, 2) : substr($s1, 0, 2);
    }

    echo sub_string("Hello", 1)."<br>";
    echo sub_string("Python", 2)."<br>";
    echo sub_string("on", 1)."<br>";
?>
