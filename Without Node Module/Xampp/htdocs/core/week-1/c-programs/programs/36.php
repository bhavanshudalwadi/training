<?php
    $array = [5, 2, 8, 1, 3];
    $searchElement = 8;

    function linearSearch($array, $searchElement) {
        foreach ($array as $key => $value) {
            if ($value == $searchElement) {
                return $key;
            }
        }
        return -1;
    }

    $result = linearSearch($array, $searchElement);
    echo "Linear Search: Element $searchElement found at index $result";
?>
