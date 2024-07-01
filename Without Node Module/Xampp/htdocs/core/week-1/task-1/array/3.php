<?php
    $arr = ['Accord', 'Civic', 'Pilot', 'City'];

    array_splice($arr, 2, 0, 'Beleno');

    echo "Cars: ".implode(", ", $arr);

    include("../next.php");
?>