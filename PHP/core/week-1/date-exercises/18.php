<?php 
    $birthdate = new DateTime("11.4.1987");
    $currentDate = new DateTime();
    $interval = $birthdate->diff($currentDate);
    echo "Your age: " . $interval->format("%y years, %m months, %d days");
?>
