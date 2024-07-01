<?php
    function arrayUnion($array1, $array2) {
        return array_unique(array_merge($array1, $array2));
    }

    $array1 = [1, 2, 3, 4, 5];
    $array2 = [3, 4, 5, 6, 7];

    $resultUnion = arrayUnion($array1, $array2);

    echo "Array 1: " . implode(', ', $array1) . "<br>";
    echo "Array 2: " . implode(', ', $array2) . "<br>";
    echo "Union of Arrays: " . implode(', ', $resultUnion);
?>
