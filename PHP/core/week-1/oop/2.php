<?php
    class Greeting {
        public function greet($name) {
            echo "Hiii, I'm $name";
        }
    }

    $greet = new Greeting();
    $greet->greet('Bhavanshu Dalwadi');
?>