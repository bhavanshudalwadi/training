<?php
    $num1 = 15;
    $num2 = 5;
    $operator = '+';
    $result = 0;

    switch ($operator) {
        case '+':
            $result = $num1 + $num2;
            break;
        case '-':
            $result = $num1 - $num2;
            break;
        case '*':
            $result = $num1 * $num2;
            break;
        case '/':
            $result = ($num2 != 0) ? $num1 / $num2 : "Cannot divide by zero";
            break;
    }

    echo "Result of $num1 $operator $num2 is: $result";
?>
