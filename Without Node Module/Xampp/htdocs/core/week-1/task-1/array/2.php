<?php
    $cars = [
        'Toyota' => ['Camry', 'Corolla', 'Rav4'],
        'Honda' => ['Accord', 'Civic', 'Pilot'],
        'Ford' => ['Fusion', 'Escape', 'Explorer']
    ];

    echo "Honda Cars: ".implode(", ", $cars['Honda']);

    include("../next.php");
?>