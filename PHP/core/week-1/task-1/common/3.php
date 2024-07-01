<?php
    // Write a PHP script to get the client IP address

    echo $_SERVER['PHP_SELF'] . "<br>";
    echo $_SERVER['HTTP_HOST'] . "<br>";
    echo $_SERVER['REMOTE_ADDR'] . "<br>";

    include("../next.php");
?>