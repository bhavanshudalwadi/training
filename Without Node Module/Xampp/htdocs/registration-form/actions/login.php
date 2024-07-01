<?php
    session_start();
    
    require "../parts/db.php";

    if(isset($_POST['kmk_id']) && isset($_POST['password']) && filter_data($_POST['kmk_id']) != null && filter_data($_POST['password']) != null) {
        $kmk_id = filter_data($_POST['kmk_id']);
        $password = filter_data($_POST['password']);

        $qry = "select * from registrations where kmk_id = '$kmk_id' and password = '$password'";

        $result = mysqli_query($con, $qry);
        
        if(mysqli_num_rows($result) > 0) {
            $row = mysqli_fetch_assoc($result);
            $_SESSION['id'] = $row['id'];
            $_SESSION['kmk_id'] = $row['kmk_id'];
            echo "<script>window.location.href = '$app_url/index.php';</script>";
        }else {
            echo "<script>window.location.href = '$app_url/login.php?e=1&msg=Invalid%20Login%20Details';</script>";
        }
    }
?>