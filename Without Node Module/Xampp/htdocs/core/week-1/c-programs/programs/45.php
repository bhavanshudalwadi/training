<?php
    $matrix = [[1, 0, 0], [4, 5, 0], [7, 8, 9]];
    $isLowerTriangular = true;

    printMatrix($matrix);
    echo "<br>";
    
    for ($i = 0; $i < count($matrix); $i++) {
        for ($j = $i + 1; $j < count($matrix[$i]); $j++) {
            if ($matrix[$i][$j] != 0) {
                $isLowerTriangular = false;
                break 2; // exit both loops
            }
        }
    }

    printMatrix($matrix);
    echo "<br>";
    echo $isLowerTriangular ? "Matrix is Lower Triangular." : "Matrix is not Lower Triangular.";

    function printMatrix($matrix) {
        foreach ($matrix as $row) {
            echo implode(", ", $row) . "<br>";
        }
    }
?>
