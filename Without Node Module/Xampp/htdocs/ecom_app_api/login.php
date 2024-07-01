<?php
    include './db.php';
    filter_data($_POST);
    extract($_POST);
    
    $data = array();
    $data["user"] = (object)array();
    if(isset($email) && isset($password)) {
        $qry = "SELECT * FROM users WHERE email = '$email'";
        $result = mysqli_query($con, $qry);
        if(!$result) {
            die("Failed to login");
        }
        if(mysqli_num_rows($result) > 0) {
            $row = mysqli_fetch_assoc($result);
            if(password_verify($password, $row["password"])) {
                $data["success"] = true;
                $data["msg"] = "Login successful";
                $data["user"] = $row;
                $data["user"]["id"] = (int)$row["id"];
            }else {
                $data["success"] = false;
                $data["msg"] = "Invalid login details";
            }
        }else {
            $data["success"] = false;
            $data["msg"] = "Failed to login";
        }
    }else {
        $data["success"] = false;
        $data["msg"] = "Invalid parameters";
    }

    echo json_encode($data);
?>