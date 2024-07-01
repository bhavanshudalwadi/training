<?php
    function concat($s1, $word) {
        return substr($s1, 0, 2).$word.substr($s1, 2);
    }
    
    echo concat("[[]]", "Hello")."<br>";
    echo concat("(())", "Hi");
?>