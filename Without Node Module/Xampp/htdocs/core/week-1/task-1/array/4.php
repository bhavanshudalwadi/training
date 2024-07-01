<?php
    $temp = [28, 30, 25, 32, 22, 27, 29, 31, 26, 30];

    $avgTemp = array_sum($temp) / count($temp);

    sort($temp);

    $lowTemp = array_slice($temp, 0, 5);
    $highTemp = array_slice($temp, -5);

    echo "Avg Temprature: $avgTemp";
    echo "<br>5 Low Tempratures: ".implode(", ", $lowTemp);
    echo "<br>5 High Tempratures: ".implode(", ", $highTemp);

    include("../next.php");
?>