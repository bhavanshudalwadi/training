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
        $msg = $user->add();

        if($msg != '') {
            echo "<script>window.location.href = '".app_url."/users.php?s=1&msg=$msg';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/edit_user.php?e=1&msg=Failed%20To%Login';</script>";
        }
    }
?>