<?php
    function sub_string($s1) { 
        if (substr($s1, 0, 3) == "abc") {
            return "abc";
        } else if (substr($s1, 0, 3) == "xyz") {
            return "xyz";
        } else {
            return "";
        }
    }

    echo sub_string("abc")."<br>";
    echo sub_string("abcdef")."<br>";
    echo sub_string("C")."<br>";
    echo sub_string("xyz")."<br>";
    echo sub_string("xyzsder")."<br>";
?>
