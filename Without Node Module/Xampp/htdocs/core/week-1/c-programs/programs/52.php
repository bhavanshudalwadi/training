<?php
    $month = 3;
    $year = 2024;

    echo "Calendar for $year - $month:<br>";
    echo date("F Y", strtotime("$year-$month-01")) . "<br>";

    $firstDay = date("N", strtotime("$year-$month-01"));
    $totalDays = cal_days_in_month(CAL_GREGORIAN, $month, $year);

    echo "<div class='d-flex justify-content-center'><table border='1'>";
    echo "<tr><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th><th>Sun</th></tr>";

    for ($i = 1 - $firstDay; $i <= $totalDays; $i++) {
        if ($i > 0) {
            echo "<td>$i</td>";
        } else {
            echo "<td></td>";
        }

        if ($i % 7 == 0) {
            echo "</tr><tr>";
        }
    }

    echo "</tr></table></div>";
?>
