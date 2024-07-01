<?php
    include './db.php';
    filter_data($_POST);
    extract($_POST);
    
    $data = array();
    if(isset($name) && isset($email) && isset($password)) {
        if(!is_already_exist("users", "email", $email)) {
            $password = password_hash($password, PASSWORD_DEFAULT);
    
            $qry = "INSERT INTO users SET name = '$name', email = '$email', password = '$password'";
            if(mysqli_query($con, $qry)) {
                $data["success"] = true;
                $data["msg"] = "Sign up successful";
            }else {
                $data["success"] = false;
                $data["msg"] = "Failed to add user details";
            }
        }else {
            $data["success"] = false;
            $data["msg"] = "Email address is already exist";
        }
    }else {
        $data["success"] = false;
        $data["msg"] = "Invalid parameters";
    }

    echo json_encode($data);
?>