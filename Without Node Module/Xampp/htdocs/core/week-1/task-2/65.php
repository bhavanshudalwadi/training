<?php
    function test($s1, $s2) {
        return strlen($s1) < strlen($s2) ? $s2 . " " . $s1 . " " . $s2 : $s1 . " " . $s2 . " " . $s1;
    }

    echo test("Hello", "Hi")."<br>";
    echo test("JS", "Python")."<br>";
?>
