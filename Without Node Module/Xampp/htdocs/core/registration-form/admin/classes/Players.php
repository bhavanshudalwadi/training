<?php
    require_once "Database.php";

    class Players extends Database {
        public $fname;
        public $mname;
        public $lname;
        public $age_group;
        public $gender;
        public $dob;
        public $sport;
        public $sub_sport;
        public $mobile;
        public $email;
        public $weight;
        public $height;
        public $district;
        public $taluko;
        public $village;
        public $caste;
        public $g_fname;
        public $g_lname;
        public $g_mobile;
        public $c_name;
        public $c_mobile;
        public $c_address;
        public $kmk_id;
        public $password;
        public $kmk_type;

        function __construct($player = null) {
            parent::__construct("kmk");

            if($player != null) {
                $this->kmk_id = "KMK".rand(1000000, 9999999);
                $this->password = Database::generate_password();
                $this->kmk_type = 0;
    
                foreach ($player as $key => $value) {
                    if (property_exists($this, $key)) {
                        $this->{$key} = $value;
                    }
                }
            }
        }

        public function add() {
            $qry = "insert into registrations
                set kmk_id = '$this->kmk_id', kmk_type = '$this->kmk_type', fname = '$this->fname', mname = '$this->mname', lname = '$this->lname', age_group = '$this->age_group', gender = '$this->gender',
                dob = '$this->dob', sport = '$this->sport', sub_sport = '$this->sub_sport', mobile = '$this->mobile', email = '$this->email', password = '$this->password', weight = $this->weight, height = $this->height,
                district = '$this->district', taluko = '$this->taluko', village = '$this->village', caste = '$this->caste', g_fname = '$this->g_fname', g_lname = '$this->g_lname', g_mobile = '$this->g_mobile',
                c_name = '$this->c_name', c_mobile = '$this->c_mobile', c_address = '$this->c_address'";

            if($this->con->query($qry)) {
                return "Player Added Successful";
            }else {
                return "Failed To Add Player Details";
            }
        }
        public function update($id) {
            $qry = "update registrations
                set fname = '$this->fname', mname = '$this->mname', lname = '$this->lname', age_group = '$this->age_group', gender = '$this->gender',
                dob = '$this->dob', sport = '$this->sport', sub_sport = '$this->sub_sport', mobile = '$this->mobile', email = '$this->email', weight = $this->weight, height = $this->height,
                district = '$this->district', taluko = '$this->taluko', village = '$this->village', caste = '$this->caste', g_fname = '$this->g_fname', g_lname = '$this->g_lname', g_mobile = '$this->g_mobile',
                c_name = '$this->c_name', c_mobile = '$this->c_mobile', c_address = '$this->c_address' where id = '$id'";

            if($this->con->query($qry)) {
                return "Player Updated Successful";
            }else {
                return "Failed To Update Player Details";
            }
        }
        public function delete($id) {
            $qry = "delete from registrations where id = '$id'";

            if($this->con->query($qry)) {
                return "Player Deleted Successful";
            }else {
                return "Failed To Delete Player Details";
            }
        }
        public function get_by_page($page_no, $records_per_page = 5) {
            $offset = ($page_no - 1) * $records_per_page;

            $qry = "select * from registrations limit $offset, $records_per_page";

            return $this->con->query($qry);
        }
        public function get_all() {
            $qry = "select * from registrations";
            $result = $this->con->query($qry);
            return $result;
        }
        public function get_by_id($id) {
            $qry = "select * from registrations where id = '$id'";
            $result = $this->con->query($qry);
            return $result;
        }

        public function get_count() {
            $qry = "select count(*) as count from registrations";
            $result = $this->con->query($qry);
            $row = $result->fetch_assoc();
            return $row["count"];
        }
    }
?>