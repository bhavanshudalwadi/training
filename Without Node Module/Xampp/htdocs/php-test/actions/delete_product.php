<?php
    if(isset($_GET['id']) && $_GET['id'] != '') {
        require "../parts/const.php";
        require "../classes/Product.php";
        $product = new Product();
        $msg = $product->delete($_GET['id']);
        
        if($msg != '') {
            header("location: ".app_url."/products.php?s=1&msg=$msg");
        }else {
            header("location: ".app_url."/products.php?s=1&msg=Failed%20To%20Delete%20Product");
        }
    }else {
        header("location: ".app_url."/products.php?s=1&msg=Failed%20To%20Delete%20Product");
    }
?>