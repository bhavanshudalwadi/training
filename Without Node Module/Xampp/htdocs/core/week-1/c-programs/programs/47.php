<?php
    $height = 5;

    for ($i = 1; $i <= $height; $i++) {
        for ($j = 1; $j <= $height - $i; $j++) {
            echo "&nbsp;";
        }

        for ($k = 1; $k <= 2 * $i - 1; $k++) {
            if ($k == 1 || $k == 2 * $i - 1 || $i == $height) {
                echo "*";
            } else {
                echo "&ensp;";
            }
        }

        echo "<br>";
    }
?>
