<?php
    $originalString = "This is a sample sentence with more than six words.";
    $wordsArray = str_word_count($originalString, 1);
    $firstSixWords = array_slice($wordsArray, 0, 6);
    echo "First 6 Words: " . implode(' ', $firstSixWords);
?>
