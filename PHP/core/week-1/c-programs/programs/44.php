<?php
    $matrix = [[1, 2, 3], [0, 4, 5], [0, 0, 6]];
    $isUpperTriangular = true;

    printMatrix($matrix);
    echo "<br />";

    for ($i = 0; $i < count($matrix); $i++) {
        for ($j = 0; $j < $i; $j++) {
            if ($matrix[$i][$j] != 0) {
                $isUpperTriangular = false;
                break 2; // exit both loops
            }
        }
    }

    echo "<br />";
    printMatrix($matrix);
    echo "<br />";
    echo $isUpperTriangular ? "Matrix is Upper Triangular." : "Matrix is not Upper Triangular.";

    function printMatrix($matrix) {
        foreach ($matrix as $row) {
            echo implode(", ", $row) . "<br>";
        }
    }
?>
