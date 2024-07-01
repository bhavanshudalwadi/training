<?php
    $strArr = ['bhavanshu', 'chintu', 'deep', 'henil', 'pratik'];
    $strLen = array_map('strlen', $strArr);

    echo "Shortest Length String: ".$strArr[array_search(min($strLen), $strLen)];
    echo "<br>Longest Length String: ".$strArr[array_search(max($strLen), $strLen)];
    
    include("../next.php");
?>