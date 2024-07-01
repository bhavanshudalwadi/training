<?php
    session_start();

    require "../parts/const.php";
    require "../classes/Users.php";
    
    if(isset($_POST['email']) && isset($_POST['password']) && Database::filter_data($_POST['email']) != null && Database::filter_data($_POST['password']) != null) {
        $data = [
            'email' => Database::filter_data($_POST['email']),
            'password' => Database::filter_data($_POST['password'])
        ];
        
        $user = new Users($data);
        $user_id = $user->checkLogin();

        if($user_id != -1) {
            $_SESSION['admin_id'] = $user_id;
            echo "<script>window.location.href = '".app_url."/index.php?s=1&msg=Login%20Successful';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/login.php?e=1&msg=Failed%20To%Login';</script>";
        }
    }
?>