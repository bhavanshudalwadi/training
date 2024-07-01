<?php
$text = "techstudy";
$countT = 0;

for ($i = 0; $i < strlen($text); $i++) {
    if ($text[$i] == 't' || $text[$i] == 'T') {
        $countT++;
    }
}

echo "Number of 't' characters in 'techstudy': $countT";
?>