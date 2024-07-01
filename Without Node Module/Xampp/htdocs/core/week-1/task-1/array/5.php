<?php
    foreach(range(50, 150) as $item) {
        echo $item % 4 == 0 ? $item.", ":"";
    }

    include("../next.php");
?>