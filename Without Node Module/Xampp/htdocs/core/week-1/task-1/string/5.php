<?php
    $originalString = "apple, banana, orange";

    print_r(str_split($originalString, 5));
    
    $splitArray = explode(', ', $originalString);
    echo "Split Array: " . implode(', ', $splitArray);
?>
