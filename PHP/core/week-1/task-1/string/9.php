<?php
    $sourceString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    $passwordLength = 8;
    $simpleRandomPassword = substr(str_shuffle($sourceString), 0, $passwordLength);
    echo "Simple Random Password: $simpleRandomPassword";
?>
