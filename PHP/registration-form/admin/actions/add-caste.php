<?php
    session_start();

    require "../parts/const.php";
    require "../classes/Castes.php";
    
    if(isset($_POST['name']) && Database::filter_data($_POST['name']) != null) {
        $data = [
            'name' => Database::filter_data($_POST['name'])
        ];
        
        $caste = new Castes($data);
        $msg = $caste->add();

        if($msg != '') {
            echo "<script>window.location.href = '".app_url."/castes.php?s=1&msg=$msg';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/edit_caste.php?e=1&msg=Failed%20To%Add%20Caste';</script>";
        }
    }
?>