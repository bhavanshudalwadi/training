<?php
    $numericString = "1,234,567.89";
    $noCommas = str_replace(',', '', $numericString);
    echo "String without Commas: $noCommas";
?>
