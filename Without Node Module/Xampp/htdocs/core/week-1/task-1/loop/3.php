<?php
$number = 5; // Change this number as needed
$factorial = 1;

for ($i = 1; $i <= $number; $i++) {
    $factorial *= $i;
}

echo "Factorial of $number: $factorial";
?>