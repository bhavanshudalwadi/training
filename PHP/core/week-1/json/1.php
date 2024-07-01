<?php
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

    $data = json_decode($json);

    foreach($data as $item) {
        echo "$item->name, $item->email, $item->phone<br>";
    }
?>