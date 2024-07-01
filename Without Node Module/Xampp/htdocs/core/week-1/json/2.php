<?php
    $json = '{"number": 123456789012345678901234567890}';
    $data = json_decode($json);
    echo $data->number;
?>