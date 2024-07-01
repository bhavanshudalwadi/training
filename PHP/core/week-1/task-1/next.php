<?php
    echo "<br><br>";
    $current = basename($_SERVER['SCRIPT_NAME'], ".php");
    echo "<a href='".($current+1).".php'>NEXT</a>";
?>