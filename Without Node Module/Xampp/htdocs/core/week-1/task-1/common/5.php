<?php
    // Write a PHP script, which changes the color of the first character of a word

    function changeFirstCharColor($inputString, $color = 'red') {
        $words = explode(' ', $inputString);
        
        foreach ($words as &$word) {
            if (!empty($word)) {
                $firstChar = mb_substr($word, 0, 1, 'UTF-8');
                $remainingChars = mb_substr($word, 1, mb_strlen($word), 'UTF-8');
                $word = "<span style='color: $color;'>$firstChar</span>$remainingChars";
            }
        }
        
        return implode(' ', $words);
    }
    
    $inputText = "Hello World! PHP is awesome.";
    $coloredText = changeFirstCharColor($inputText);
    
    echo "<p>$coloredText</p>";

    include("../next.php");
?>