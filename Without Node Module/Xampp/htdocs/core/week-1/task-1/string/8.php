<?php
    $originalString = "the quick brown fox jumps over the lazy dog";
    $modifiedString = preg_replace('/\bthe\b/', 'best', $originalString, 1);
    echo "Modified String: $modifiedString";
?>
