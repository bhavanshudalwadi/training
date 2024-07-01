<?php
    function test($s1) : string {
        $s1 = trim($s1);
        $len = strlen($s1);

        if ($len >= 2) {
            $s1 = substr($s1, 0, 2);
        } else if ($len > 0) {
            $s1 = substr($s1, 0, 1) . "#";
        } else {
            $s1 = "##";
        }

        return $s1;
    }

    echo test("Hello")."<br>";
    echo test("Python")."<br>";
    echo test("a")."<br>";
    echo test(" ")."<br>";
?>
