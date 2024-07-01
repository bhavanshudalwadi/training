<?php
    function isMagicSquare($matrix) {
        $n = count($matrix);
        $expectedSum = $n * ($n * $n + 1) / 2;

        for ($i = 0; $i < $n; $i++) {
            $rowSum = $colSum = 0;
            for ($j = 0; $j < $n; $j++) {
                $rowSum += $matrix[$i][$j];
                $colSum += $matrix[$j][$i];
            }

            if ($rowSum != $expectedSum || $colSum != $expectedSum) {
                return false;
            }
        }

        $primaryDiagonalSum = $secondaryDiagonalSum = 0;
        for ($i = 0; $i < $n; $i++) {
            $primaryDiagonalSum += $matrix[$i][$i];
            $secondaryDiagonalSum += $matrix[$i][$n - $i - 1];
        }

        if ($primaryDiagonalSum != $expectedSum || $secondaryDiagonalSum != $expectedSum) {
            return false;
        }

        echo "Primary Diagonal Sum: $primaryDiagonalSum<br>";
        echo "Secondary Diagonal Sum: $secondaryDiagonalSum<br>";

        return true;
    }

    function printMatrix($matrix) {
        foreach ($matrix as $row) {
            echo implode(", ", $row) . "<br>";
        }
    }

    $matrix = [
        [2, 7, 6],
        [9, 5, 1],
        [4, 3, 8]
    ];

    printMatrix($matrix);

    if (isMagicSquare($matrix)) {
        echo "It's a magic square!";
    } else {
        echo "It's not a magic square.";
    }
?>
