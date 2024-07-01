<?php
    function sub_string($s1) { 
        $firstTwo = substr($s1, 0, 2); 
        $lastTwo = substr($s1, strlen($s1) - 2, 2);

        return $firstTwo == $lastTwo;
    }

    var_dump(sub_string("abab"));
    var_dump(sub_string("abcdef"));
    var_dump(sub_string("xyzsderxy"));
?>
