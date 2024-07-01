<?php
    if(isset($_GET['id']) && $_GET['id'] != '') {
        require "../parts/const.php";
        require "../classes/SubSports.php";
        $sub_sports = new SubSports();
        $msg = $sub_sports->delete($_GET['id']);
        
        if($msg != '') {
            header("location: ".app_url."/sports.php?s=1&msg=$msg");
        }else {
            header("location: ".app_url."/sports.php?s=1&msg=Failed%20To%20Delete%20Sub%20Sport");
        }
    }else {
        header("location: ".app_url."/sports.php?s=1&msg=Failed%20To%20Delete%20Sub%20Sport");
    }
?>