<?php
    session_start();
    require "parts/const.php";

    if(isset($_SESSION['admin_id'])) {
        session_unset();
        session_destroy();

        // header("Location: ./login.php");
    }
    echo "<script>window.location.href = '".app_url."/login.php';</script>";
?>