<?php
    $str = "Programming is Fun";
    $vowelsCount = preg_match_all('/[aeiouAEIOU]/', $str, $vowels);
    $consonantsCount = preg_match_all('/[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]/', $str, $consonants);

    echo "Number of vowels: $vowelsCount<br>";
    echo "Number of consonants: $consonantsCount";
?>
