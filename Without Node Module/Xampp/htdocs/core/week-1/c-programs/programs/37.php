<?php
    $array = [1, 2, 3, 5, 8];
    $searchElement = 5;

    function binarySearch($array, $searchElement) {
        $low = 0;
        $high = count($array) - 1;

        while ($low <= $high) {
            $mid = floor(($low + $high) / 2);

            if ($array[$mid] == $searchElement) {
                return $mid;
            } elseif ($array[$mid] < $searchElement) {
                $low = $mid + 1;
            } else {
                $high = $mid - 1;
            }
        }

        return -1;
    }

    $result = binarySearch($array, $searchElement);
    echo "Binary Search: Element $searchElement found at index $result";
?>
