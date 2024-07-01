<?php
    $str1 = "listen";
    $str2 = "silent";

    function areAnagrams($str1, $str2) {
        return count_chars($str1, 1) === count_chars($str2, 1);
    }

    if (areAnagrams($str1, $str2)) {
        echo "$str1 and $str2 are anagrams.";
    } else {
        echo "$str1 and $str2 are not anagrams.";
    }
?>
