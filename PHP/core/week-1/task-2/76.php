<?php
    function test($s1, $s2) { 
        $str = "";

        if (strlen($s1) > 0) {
            $str = substr($s1, 0, 1);
        } else{
            $str = "#";
        }

        if (strlen($s2) > 0) {
            $str = $str.substr($s2, strlen($s2) - 1);
        } else {
            $str = $str."#";
        }

        return $str;
    }

    echo test("Hello", "Hi")."<br>";
    echo test("Python", "PHP")."<br>";
    echo test("JS", "JS")."<br>";
    echo test("Csharp", "")."<br>";
?>
