<?php
    function get_browser_name() {
        $user_agent = $_SERVER['HTTP_USER_AGENT'];
    
        // Check for common browsers
        if (strpos($user_agent, 'MSIE') !== false || strpos($user_agent, 'Trident/') !== false) {
            return 'Internet Explorer';
        } elseif (strpos($user_agent, 'Firefox') !== false) {
            return 'Firefox';
        } elseif (strpos($user_agent, 'Chrome') !== false) {
            return 'Google Chrome';
        } elseif (strpos($user_agent, 'Safari') !== false) {
            return 'Safari';
        } elseif (strpos($user_agent, 'Opera') !== false || strpos($user_agent, 'OPR/') !== false) {
            return 'Opera';
        } else {
            return 'Unknown';
        }
    }
    
    $browser = get_browser_name();
    echo "You are using: $browser <br>";
    echo $_SERVER['HTTP_USER_AGENT'] . "<br>";

    include("../next.php");
?>