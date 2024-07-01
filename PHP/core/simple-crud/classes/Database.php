<?php
    class Database {
        public $con;

        public function __construct($db_name) {
            $this->con = new mysqli("localhost", "root", "", $db_name);

            if ($this->con->connect_error) {
                die("Connection failed: " . $this->con->connect_error);
            }
        }

        public function __destruct() {
            $this->con->close();
        }

        public static function filter_data($input) {
            $input = trim($input);
            return  $input != ''?$input:null;
        }
    
        public static function generate_password() {
            $alphabet = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890';
            $pass = array();
            $alphaLength = strlen($alphabet) - 1;
            for ($i = 0; $i < 8; $i++) {
                $n = rand(0, $alphaLength);
                $pass[] = $alphabet[$n];
            }
            return implode($pass);
        }
    }
?>