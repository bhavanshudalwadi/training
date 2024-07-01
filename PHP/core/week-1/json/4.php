<?php
    function printJsonData($json) {
        // $data = json_decode($json);      // Gives Josn Obj => stdClass Object
        $data = json_decode($json, true);   // Gives Json Obj => Associative Array
        $err = json_last_error();

        if ($err !== JSON_ERROR_NONE) {
            echo "JSON decoding error: " . json_last_error_msg();
        }else {
            echo "Json Data: <br>";
            foreach($data as $item) {
                foreach($item as $key => $details) {
                    echo "$key = $details, ";
                }
                echo "<br>";
            }
        }
    }

    $json = '[
        {
          "name": "Bhavanshu",
          "email": "bhavanshu@gmail.com",
          "phone": "7556971234"
        },
        {
          "name": "Jainil",
          "email": "jainil@gmail.com",
          "phone": "8557885678"
        },
        {
          "name": "Henil",
          "email": "henil@gmail.com",
          "phone": "9552699876"
        }
    ]';

    printJsonData($json);
?>