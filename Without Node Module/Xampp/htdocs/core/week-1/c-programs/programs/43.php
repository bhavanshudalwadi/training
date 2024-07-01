<?php
    $matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
    $transposedMatrix = [];

    for ($i = 0; $i < count($matrix); $i++) {
        for ($j = 0; $j < count($matrix[$i]); $j++) {
            $transposedMatrix[$j][$i] = $matrix[$i][$j];
        }
    }

    echo "Transpose of Matrix:<br>";
    printMatrix($transposedMatrix);

    function printMatrix($matrix) {
        foreach ($matrix as $row) {
            echo implode(", ", $row) . "<br>";
        }
    }
?>
