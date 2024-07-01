<?php
    $rows = 5;

    for ($i = 0; $i < $rows; $i++) {
        $number = 1;
        echo str_repeat(" ", $rows - $i);

        for ($j = 0; $j <= $i; $j++) {
            echo $number . " ";
            $number = $number * ($i - $j) / ($j + 1);
        }

        echo "<br>";
    }
?>
