<?php
    $array = [5, 2, 8, 1, 3];

    function quickSort($array) {
        $length = count($array);

        if ($length <= 1) {
            return $array;
        }

        $pivot = $array[0];
        $left = $right = [];

        for ($i = 1; $i < $length; $i++) {
            if ($array[$i] < $pivot) {
                $left[] = $array[$i];
            } else {
                $right[] = $array[$i];
            }
        }

        return array_merge(quickSort($left), [$pivot], quickSort($right));
    }

    $sortedArray = quickSort($array);
    echo "Quick Sort: Sorted array: " . implode(", ", $sortedArray);
?>
