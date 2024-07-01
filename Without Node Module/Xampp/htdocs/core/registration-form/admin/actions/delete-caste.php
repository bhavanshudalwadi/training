<?php
    if(isset($_GET['id']) && $_GET['id'] != '') {
        require "../parts/const.php";
        require "../classes/Castes.php";
        $caste = new Castes();
        $msg = $caste->delete($_GET['id']);
        
        if($msg != '') {
            header("location: ".app_url."/castes.php?s=1&msg=$msg");
        }else {
            header("location: ".app_url."/castes.php?s=1&msg=Failed%20To%20Delete%20Caste");
        }
    }else {
        header("location: ".app_url."/castes.php?s=1&msg=Failed%20To%20Delete%20Caste");
    }
?>