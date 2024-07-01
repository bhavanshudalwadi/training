<?php
    // Write a PHP program to remove duplicates from a sorted list

    $list = [67, 57, 89, 25, 59, 39, 20, 47, 67, 89, 25, 89];

    echo "List: ";
    print_r(implode(", ", $list));

    sort($list);
    echo "<br><br>";

    echo "Sorted List: ";
    print_r(implode(", ", $list));

    $list = array_unique($list);
    echo "<br><br>";

    echo "Unique List: ";
    print_r(implode(", ", $list));
?>