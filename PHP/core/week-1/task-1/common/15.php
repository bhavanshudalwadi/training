<?php
    for($i = 1; $i <= 5; $i++) {
        for($j=1; $j <= 10; $j++) {
            echo "$i * $j = ".$i*$j."<br>";
            if($i * $j == 25) {
                break 2;
            }
        }
        echo "<br>";
    }
?>