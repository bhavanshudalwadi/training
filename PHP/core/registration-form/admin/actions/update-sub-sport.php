<?php
    session_start();

    require "../parts/const.php";
    require "../classes/SubSports.php";
    
    if(isset($_POST['name']) && isset($_POST['sport_id']) && Database::filter_data($_POST['name']) != null && Database::filter_data($_POST['sport_id']) != null) {
        $data = [
            'name' => Database::filter_data($_POST['name']),
            'sport_id' => Database::filter_data($_POST['sport_id']),
        ];
        
        $sub_sports = new SubSports($data);
        $msg = $sub_sports->update($_POST['id']);

        if($msg != '') {
            echo "<script>window.location.href = '".app_url."/sub_sports.php?s=1&msg=$msg';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/edit-sub-sport.php?id=".$_POST['id']."&e=1&msg=Failed%20To%Update%20Sub%20Sport';</script>";
        }
    }
?>