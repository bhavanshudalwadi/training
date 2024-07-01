<?php
    $cars = [
        'Toyota' => ['Camry', 'Corolla', 'Rav4'],
        'Honda' => ['Accord', 'Civic', 'Pilot'],
        'Ford' => ['Fusion', 'Escape', 'Explorer']
    ];

    foreach($cars as $key => $car_items) {
        echo "<h3>".$key." Cars:</h3>";
        echo "<ul>";
        foreach($car_items as $car) {
            echo "<li>$car</li>";
        }
        echo "</ul>";
    }

    include("../next.php");
?>