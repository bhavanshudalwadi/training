<?php
    $matrix1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
    $matrix2 = [[9, 8, 7], [6, 5, 4], [3, 2, 1]];
    $resultMatrix = [];

    for ($i = 0; $i < count($matrix1); $i++) {
        for ($j = 0; $j < count($matrix1[$i]); $j++) {
            $resultMatrix[$i][$j] = $matrix1[$i][$j] - $matrix2[$i][$j];
        }
    }

    echo "Matrix Subtraction:<br>";
    printMatrix($resultMatrix);

    function printMatrix($matrix) {
        foreach ($matrix as $row) {
            echo implode(", ", $row) . "<br>";
        }
    }
?>
