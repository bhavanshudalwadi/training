<?php
    $string = "level";
    if (is_palindrome($string)) {
        echo "$string is a palindrome.";
    } else {
        echo "$string is not a palindrome.";
    }

    function is_palindrome($str) {
        return $str == strrev($str);
    }
?>