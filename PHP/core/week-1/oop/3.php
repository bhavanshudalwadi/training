<?php
    class FactorialCalculator {
        public function calculateFactorial($num) {
            if ($num < 0) {
                return "Factorial is not defined for negative numbers.";
            }

            $result = 1;
            for ($i = 1; $i <= $num; $i++) {
                $result *= $i;
            }
            return $result;
        }
    }

    $calculator = new FactorialCalculator();
    echo $calculator->calculateFactorial(5);
?>