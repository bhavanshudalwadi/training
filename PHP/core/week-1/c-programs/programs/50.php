<?php
    $height = 5;

    for ($i = 1; $i <= $height; $i++) {
        for ($j = 1; $j <= $height - $i; $j++) {
            echo " ";
        }

        for ($k = 1; $k <= 2 * $i - 1; $k++) {
            echo "*";
        }

        echo "<br>";
    }

    for ($i = $height - 1; $i >= 1; $i--) {
        for ($j = 1; $j <= $height - $i; $j++) {
            echo " ";
        }

        for ($k = 1; $k <= 2 * $i - 1; $k++) {
            echo "*";
        }

        echo "<br>";
    }
?>
