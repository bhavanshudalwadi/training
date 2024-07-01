<?php
    $array = [5, 2, 8, 1, 3];

    function mergeSort($array) {
        $length = count($array);

        if ($length <= 1) {
            return $array;
        }

        $mid = (int)($length / 2);
        $left = array_slice($array, 0, $mid);
        $right = array_slice($array, $mid);

        $left = mergeSort($left);
        $right = mergeSort($right);

        return merge($left, $right);
    }

    function merge($left, $right) {
        $result = [];
        $leftLength = count($left);
        $rightLength = count($right);
        $i = $j = 0;

        while ($i < $leftLength && $j < $rightLength) {
            if ($left[$i] < $right[$j]) {
                $result[] = $left[$i];
                $i++;
            } else {
                $result[] = $right[$j];
                $j++;
            }
        }

        while ($i < $leftLength) {
            $result[] = $left[$i];
            $i++;
        }

        while ($j < $rightLength) {
            $result[] = $right[$j];
            $j++;
        }

        return $result;
    }

    $sortedArray = mergeSort($array);
    echo "Merge Sort: Sorted array: " . implode(", ", $sortedArray);
?>
