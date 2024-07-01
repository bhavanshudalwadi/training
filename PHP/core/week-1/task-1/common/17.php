<?php
    $list1 = range(4, 9);
    $list2 = $list1;

    shuffle($list2);

    echo "List 1: ".implode(", ", $list1);
    echo "<br>List 2: ".implode(", ", $list2);

    $list1 = array_map(function ($a, $b) { return $a * $b; }, $list1, $list2);

    echo "<br>Result: ".implode(", ", $list1);
?>