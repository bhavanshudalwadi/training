<?php
    if(isset($_GET['id']) && $_GET['id'] != '') {
        require "../parts/const.php";
        require "../classes/Users.php";
        $user = new Users();
        $msg = $user->delete($_GET['id']);
        
        if($msg != '') {
            header("location: ".app_url."/users.php?s=1&msg=$msg");
        }else {
            header("location: ".app_url."/users.php?s=1&msg=Failed%20To%20Delete%20Player");
        }
    }else {
        header("location: ".app_url."/users.php?s=1&msg=Failed%20To%20Delete%20Player");
    }
?>