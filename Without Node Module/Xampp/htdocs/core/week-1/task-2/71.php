<?php
    function concat($s1) { 
        return substr($s1, strlen($s1)-2, 2);
    }

    var_dump(concat("Hello"));
    var_dump(concat("Python"));
    var_dump(concat("on"));
    var_dump(concat("o"));
?>
