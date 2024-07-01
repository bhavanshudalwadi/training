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
            // $input = mysqli_real_escape_string($this->con, trim($input));
            $input = trim($input);
            return  $input != ''?$input:null;
        }
    }
?>