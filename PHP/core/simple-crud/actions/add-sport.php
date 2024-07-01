<?php
    session_start();

    require "../parts/const.php";
    require "../classes/Sports.php";
    
    if(isset($_POST['name']) && Database::filter_data($_POST['name']) != null) {
        $data = [
            'name' => Database::filter_data($_POST['name'])
        ];
        
        $sport = new Sports($data);
        $msg = $sport->add();

        if($msg != '') {
            echo "<script>window.location.href = '".app_url."/index.php?s=1&msg=$msg';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/edit-sport.php?e=1&msg=Failed%20To%Add%20Sport';</script>";
        }
    }
?>