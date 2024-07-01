<?php
    function lowestNonZeroInteger($array) {
        $nonZeroValues = array_filter($array, function ($value) {
            return $value !== 0;
        });

        if (empty($nonZeroValues)) {
            return null;
        }

        return min($nonZeroValues);
    }

    $array = [0, 3, 5, 0, 8, 0, 2];

    echo "Lowest NonZero Integer: ".lowestNonZeroInteger($array);

    include("../next.php");
?>
