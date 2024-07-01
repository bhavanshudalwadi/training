<?php
    $array = [5, 2, 8, 1, 3];
    $length = count($array);

    for ($i = 1; $i < $length; $i++) {
        $key = $array[$i];
        $j = $i - 1;

        while ($j >= 0 && $array[$j] > $key) {
            $array[$j + 1] = $array[$j];
            $j = $j - 1;
        }

        $array[$j + 1] = $key;
    }

    echo "Sorted array: " . implode(", ", $array);
?>
