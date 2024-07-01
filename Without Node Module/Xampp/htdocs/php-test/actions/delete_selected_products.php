<?php
    require "../parts/const.php";
    if(isset($_POST["products"]) && count($_POST["products"]) > 0) {
        require "../classes/Product.php";
        $product = new Product();
        foreach($_POST["products"] as $key => $value) {
            $product->delete($value);
        }
        header("location: ".app_url."/products.php?s=1&msg=Products%20Deleted");
    }else {
        header("location: ".app_url."/products.php?e=1&msg=Select%20Products");
    }
?>