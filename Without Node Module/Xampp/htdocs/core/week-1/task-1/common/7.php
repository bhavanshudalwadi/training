<?php
    // Write a simple PHP program to check that email id is valid or not

    function email_validation($str) { 
        return (!preg_match("^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$^", $str))?FALSE:TRUE; 
    } 
    
    $email = "admin@khelmahakumbh.gujarat.gov.in";

    if(!email_validation($email)) { 
        echo "$email is Invalid email address."; 
    }else { 
        echo "$email is Valid email address."; 
    } 
?>