<?php
    require "../parts/const.php";
    require "../classes/Product.php";
    
    if(isset($_POST['name']) && isset($_POST['cat_id']) && Database::filter_data($_POST['name']) != null && Database::filter_data($_POST['cat_id']) != null) {
        $data = [
            'name' => Database::filter_data($_POST['name']),
            'cat_id' => Database::filter_data($_POST['cat_id'])
        ];
        
        $fileName = "";
        if(isset($_FILES['img']) && $_FILES['img']['size'] > 0) {
            $fileName = rand(100,999)."_".$_FILES['img']['name'];
            move_uploaded_file($_FILES['img']['tmp_name'], "../uploads/products/".$fileName);
            $data['img'] = $fileName;
        }

        $product = new Product($data);
        $msg = $product->update($_POST['id']);

        if($msg != '') {
            echo "<script>window.location.href = '".app_url."/products.php?s=1&msg=$msg';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/edit_product.php?id=".$_POST['id']."&e=1&msg=Failed%20To%Update%20Record';</script>";
        }
    }
?>