<?php
    class MyCalculator {
        private $num1;
        private $num2;

        public function __construct($num1, $num2) {
            $this->num1 = $num1;
            $this->num2 = $num2;
        }

        public function add() {
            return $this->num1 + $this->num2;
        }

        public function multiply() {
            return $this->num1 * $this->num2;
        }
    }

    $mycalc = new MyCalculator(12, 6);
    echo $mycalc->add();
    echo $mycalc->multiply();
?>