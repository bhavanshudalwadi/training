<?php
    $date1 = new DateTime('1981-11-04');
    $date2 = new DateTime('2013-09-04');

    $interval = $date1 -> diff($date2);

    echo $interval->format('%y years, %m months, %d days');
?>
