<?php
    require_once "Database.php";

    class SubSports extends Database {
        public $name;
        public $sport_id;
        public $table_name = "sub_sports";

        function __construct($sub_sport = null) {
            parent::__construct("kmk");

            if($sub_sport != null) {
                foreach ($sub_sport as $key => $value) {
                    if (property_exists($this, $key)) {
                        $this->{$key} = $value;
                    }
                }
            }
        }

        public function add() {
            $qry = "insert into $this->table_name set name = '$this->name', sport_id = '$this->sport_id'";

            if($this->con->query($qry)) {
                return "Sub Sport Added Successful";
            }else {
                return "Failed To Add Sub Sport Details";
            }
        }
        public function update($id) {
            $qry = "update $this->table_name set name = '$this->name', sport_id = '$this->sport_id' where id = '$id'";

            if($this->con->query($qry)) {
                return "Sub Sport Updated Successful";
            }else {
                return "Failed To Update Sub Sport Details";
            }
        }
        public function delete($id) {
            $qry = "delete from $this->table_name where id = '$id'";

            if($this->con->query($qry)) {
                return "Sub Sport Deleted Successful";
            }else {
                return "Failed To Delete Sub Sport Details";
            }
        }
        public function get_by_page($page_no, $records_per_page = 5) {
            $offset = ($page_no - 1) * $records_per_page;

            $qry = "select * from $this->table_name limit $offset, $records_per_page";

            return $this->con->query($qry);
        }
        public function get_all() {
            $qry = "select * from $this->table_name";
            $result = $this->con->query($qry);
            return $result;
        }
        public function get_by_id($id) {
            $qry = "select * from $this->table_name where id = '$id'";
            $result = $this->con->query($qry);
            return $result;
        }

        public function get_count() {
            $qry = "select count(*) as count from $this->table_name";
            $result = $this->con->query($qry);
            $row = $result->fetch_assoc();
            return $row["count"];
        }
    }
?>