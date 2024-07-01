<?php
    require "../parts/const.php";
    require "../classes/Players.php";
    
    if(isset($_POST['fname']) && Database::filter_data($_POST['fname']) != null) {
        $data = [
            'fname' => Database::filter_data($_POST['fname']),
            'mname' => Database::filter_data($_POST['mname']),
            'lname' => Database::filter_data($_POST['lname']),
            'age_group' => Database::filter_data($_POST['age_group']),
            'gender' => Database::filter_data($_POST['gender']),
            'dob' => Database::filter_data($_POST['dob']),
            'sport' => Database::filter_data($_POST['sport']),
            'sub_sport' => Database::filter_data($_POST['sub_sport']),
            'mobile' => Database::filter_data($_POST['mobile']),
            'email' => Database::filter_data($_POST['email']),
            'weight' => Database::filter_data($_POST['weight']),
            'height' => Database::filter_data($_POST['height']),
            'district' => Database::filter_data($_POST['district']),
            'taluko' => Database::filter_data($_POST['taluko']),
            'village' => Database::filter_data($_POST['village']),
            'caste' => Database::filter_data($_POST['caste']),
            'g_fname' => Database::filter_data($_POST['g_fname']),
            'g_lname' => Database::filter_data($_POST['g_lname']),
            'g_mobile' => Database::filter_data($_POST['g_mobile']),
            'c_name' => Database::filter_data($_POST['c_name']),
            'c_mobile' => Database::filter_data($_POST['c_mobile']),
            'c_address' => Database::filter_data($_POST['c_address'])
        ];
        
        $player = new Players($data);
        $msg = $player->update($_POST['id']);

        if($msg != '') {
            echo "<script>window.location.href = '".app_url."/players.php?s=1&msg=$msg';</script>";
        }else {
            echo "<script>window.location.href = '".app_url."/edit-player.php?id=".$_POST['id']."&e=1&msg=Failed%20To%Update%20Record';</script>";
        }
    }
?>