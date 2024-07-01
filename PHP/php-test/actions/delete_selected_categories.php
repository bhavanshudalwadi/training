<?php
    require "../parts/const.php";
    if(isset($_POST["categories"]) && count($_POST["categories"]) > 0) {
        require "../classes/Category.php";
        $category = new Category();
        foreach($_POST["categories"] as $key => $value) {
            $category->delete($value);
        }
        header("location: ".app_url."/categories.php?s=1&msg=Categories%20Deleted");
    }else {
        header("location: ".app_url."/categories.php?e=1&msg=Select%20Categories");
    }
?>