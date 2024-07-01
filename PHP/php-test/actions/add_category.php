<?php
    require "../parts/const.php";
    require "../classes/Category.php";
    
    if(isset($_POST['name']) && Database::filter_data($_POST['name']) != null) {
        $data = [
            'name' => Database::filter_data($_POST['name']),
            'img' => null
        ];

        $fileName = "";
        if(isset($_FILES['img']) && $_FILES['img']['size'] > 0) {
            if(str_contains('image/', $_FILES['img']['type'])) {
                $fileName = rand(100,999)."_".$_FILES['img']['name'];
                move_uploaded_file($_FILES['img']['tmp_name'], "../uploads/categories/".$fileName);
                $data['img'] = $fileName;
            }
        }
        
        $category = new Category($data);
        $msg = $category->add();

        if($msg != '') {
            echo "<script>window.location.href = '".app_url."/categories.php?s=1&msg=$msg';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/edit_category.php?e=1&msg=Failed%20To%Add%20Category';</script>";
        }
    }
?>