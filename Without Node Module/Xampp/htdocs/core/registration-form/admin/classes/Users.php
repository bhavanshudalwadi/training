<?php
    require_once "Database.php";

    class Users extends Database {
        public $email;
        public $password;

        function __construct($user = null) {
            parent::__construct("kmk");

            if($user != null) {
                foreach ($user as $key => $value) {
                    if (property_exists($this, $key)) {
                        $this->{$key} = $value;
                    }
                }
            }
        }

        public function add() {
            $qry = "insert into users set email = '$this->email', password = '$this->password'";

            if($this->con->query($qry)) {
                return "User Added Successful";
            }else {
                return "Failed To Add User Details";
            }
        }
        public function update($id) {
            $qry = "update users set email = '$this->email', password = '$this->password' where id = '$id'";

            if($this->con->query($qry)) {
                return "User Updated Successful";
            }else {
                return "Failed To Update User Details";
            }
        }
        public function delete($id) {
            $qry = "delete from users where id = '$id'";

            if($this->con->query($qry)) {
                return "User Deleted Successful";
            }else {
                return "Failed To Delete User Details";
            }
        }
        public function get_by_page($page_no, $records_per_page = 5) {
            $offset = ($page_no - 1) * $records_per_page;

            $qry = "select * from users limit $offset, $records_per_page";

            return $this->con->query($qry);
        }
        public function get_all() {
            $qry = "select * from users";
            $result = $this->con->query($qry);
            return $result;
        }
        public function get_by_id($id) {
            $qry = "select * from users where id = '$id'";
            $result = $this->con->query($qry);
            return $result;
        }

        public function get_count() {
            $qry = "select count(*) as count from users";
            $result = $this->con->query($qry);
            $row = $result->fetch_assoc();
            return $row["count"];
        }

        public function checkLogin() {
            $qry = "select * from users where email = '$this->email' and password = '$this->password'";
            $result = $this->con->query($qry);
            if($result->num_rows > 0) {
                $row = $result->fetch_assoc();
                return $row['id'];
            }else {
                return -1;
            }
        }
    }
?>