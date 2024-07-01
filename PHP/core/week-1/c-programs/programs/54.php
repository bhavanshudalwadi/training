<?php
    $matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ];

    $primarySum = 0;
    $secondarySum = 0;

    for ($i = 0; $i < count($matrix); $i++) {
        $primarySum += $matrix[$i][$i];
        $secondarySum += $matrix[$i][count($matrix) - 1 - $i];
    }

    echo "Primary Diagonal Sum: $primarySum<br>";
    echo "Secondary Diagonal Sum: $secondarySum";
?>
