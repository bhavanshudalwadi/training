<?php
    function test($s1) { 
        return substr($s1, (strlen($s1) - 1) / 2 - 1, 3);
    }

    echo test("Hello")."<br>";
    echo test("Python")."<br>";
    echo test("abc")."<br>";
?>
