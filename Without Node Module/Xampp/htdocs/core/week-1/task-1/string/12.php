<?php
    $originalString = "This is a test";
    $insertString = "not ";
    $position = 5;
    $modifiedString = substr_replace($originalString, $insertString, $position, 0);
    echo "Modified String: $modifiedString";
?>
