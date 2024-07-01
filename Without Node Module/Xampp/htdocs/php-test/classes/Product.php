<?php
    require_once "Database.php";

    class Product extends Database {
        public $name;
        public $cat_id;
        public $img;

        public $table_name = "products";

        function __construct($product = null) {
            parent::__construct("php_test");

            if($product != null) {
                foreach ($product as $key => $value) {
                    if (property_exists($this, $key)) {
                        $this->{$key} = $value;
                    }
                }
            }
        }

        public function add() {
            $qry_part = "";
            if(isset($this->img)) {
                $qry_part = ", img = '".$this->img."'";
            }
            $qry = "insert into $this->table_name set name = '$this->name', cat_id = '$this->cat_id' $qry_part";

            if($this->con->query($qry)) {
                return "Product Added Successful";
            }else {
                return "Failed To Add Product Details";
            }
        }
        public function update($id) {
            $qry_part = "";
            if(isset($this->img)) {
                $qry_part = ", img = '".$this->img."'";
            }
            $qry = "update $this->table_name set name = '$this->name', cat_id = '$this->cat_id' $qry_part where id = '$id'";

            if($this->con->query($qry)) {
                return "Product Updated Successful";
            }else {
                return "Failed To Update Product Details";
            }
        }
        public function delete($id) {
            $qry = "delete from $this->table_name where id = '$id'";

            if($this->con->query($qry)) {
                return "Product Deleted Successful";
            }else {
                return "Failed To Delete Product Details";
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