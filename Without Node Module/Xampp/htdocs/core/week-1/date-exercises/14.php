<?php 
    $date = new DateTime("now", new DateTimeZone("Australia/Melbourne"));
    echo $date->format("Y-m-d H:i:s");
?>
