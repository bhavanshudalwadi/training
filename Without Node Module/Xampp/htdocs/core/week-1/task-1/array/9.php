<?php
    $arr = [5, 2, 8, 1, 7];

    rsort($arr);

    echo "Sorted Array: " . implode(', ', $arr);

    include("../next.php");
?>
