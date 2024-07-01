<?php
    $matrix1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
    $matrix2 = [[9, 8, 7], [6, 5, 4], [3, 2, 1]];
    $resultMatrix = [];

    for ($i = 0; $i < count($matrix1); $i++) {
        for ($j = 0; $j < count($matrix2[0]); $j++) {
            $resultMatrix[$i][$j] = 0;
            for ($k = 0; $k < count($matrix1[0]); $k++) {
                $resultMatrix[$i][$j] += $matrix1[$i][$k] * $matrix2[$k][$j];
            }
        }
    }

    echo "Matrix Multiplication:<br>";
    printMatrix($resultMatrix);

    function printMatrix($matrix) {
        foreach ($matrix as $row) {
            echo implode(", ", $row) . "<br>";
        }
    }
?>
