<?php 
    $timezone = new DateTimeZone("Australia/Melbourne");
    $currentDateTime = new DateTime("now", $timezone);
    echo $currentDateTime->format("Y-m-d H:i:s");
?>
