<?php
    require_once "Database.php";

    class Category extends Database {
        public $name;
        public $img;

        public $table_name = "categories";

        function __construct($category = null) {
            parent::__construct("php_test");

            if($category != null) {
                foreach ($category as $key => $value) {
                    if (property_exists($this, $key)) {
                        $this->{$key} = $value;
                    }
                }
            }
        }

        public function add() {
            $qry_part = "";
            if(isset($this->img) && $this->img != null) {
                $qry_part = ", img = '".$this->img."'";
            }
            $qry = "insert into $this->table_name set name = '$this->name' $qry_part";

            if($this->con->query($qry)) {
                return "Category Added Successful";
            }else {
                return "Failed To Add Category Details";
            }
        }
        public function update($id) {
            $qry_part = "";
            if(isset($this->img) && $this->img != null) {
                $qry_part = ", img = '".$this->img."'";
            }
            $qry = "update $this->table_name set name = '$this->name' $qry_part where id = '$id'";

            if($this->con->query($qry)) {
                return "Category Updated Successful";
            }else {
                return "Failed To Update Category Details";
            }
        }
        public function delete($id) {
            $qry = "delete from $this->table_name where id = '$id'";

            if($this->con->query($qry)) {
                return "Category Deleted Successful";
            }else {
                return "Failed To Delete Category Details";
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