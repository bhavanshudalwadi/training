<?php
    class ArraySorter {
        public function sortArray($arr) {
            sort($arr);
            return $arr;
        }
    }

    $sorter = new ArraySorter();
    $inputArray = [11, -2, 4, 35, 0, 8, -9];
    $outputArray = $sorter->sortArray($inputArray);
    print_r($outputArray);
?>