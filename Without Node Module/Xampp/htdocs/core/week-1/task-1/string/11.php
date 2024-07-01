<?php
    $originalString = "RemoveThisString";
    $removePart = "RemoveThis";
    $modifiedString = substr($originalString, strlen($removePart));
    echo "Modified String: $modifiedString";
?>
