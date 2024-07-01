<?php
    require "../parts/db.php";
    require "../mailer/send_mail.php";

    if(isset($_POST['kmk_id']) && filter_data($_POST['kmk_id']) != null) {

        $kmk_id = filter_data($_POST['kmk_id']);

        $fname = filter_data($_POST['fname']);
        $mname = filter_data($_POST['mname']);
        $lname = filter_data($_POST['lname']);
        $age_group = filter_data($_POST['age_group']);
        $gender = filter_data($_POST['gender']);
        $dob = filter_data($_POST['dob']);
        $sport = filter_data($_POST['sport']);
        $sub_sport = filter_data($_POST['sub_sport']);
        $mobile = filter_data($_POST['mobile']);
        $email = filter_data($_POST['email']);
        $weight = filter_data($_POST['weight']);
        $height = filter_data($_POST['height']);
        $district = filter_data($_POST['district']);
        $taluko = filter_data($_POST['taluko']);
        $village = filter_data($_POST['village']);
        $caste = filter_data($_POST['caste']);
        $g_fname = filter_data($_POST['g_fname']);
        $g_lname = filter_data($_POST['g_lname']);
        $g_mobile = filter_data($_POST['g_mobile']);
        $c_name = filter_data($_POST['c_name']);
        $c_mobile = filter_data($_POST['c_mobile']);
        $c_address = filter_data($_POST['c_address']);
        $old_profile = filter_data($_POST['old_profile']);

        $path = "";
        if(isset($_FILES['profile_url'])) {
            if($old_profile != '') {
                if(file_exists("../uploads/".$old_profile)) {
                    unlink("../uploads/".$old_profile);
                }
            }
            $fileName = rand(100,999)."_".$_FILES['profile_url']['name'];
            move_uploaded_file($_FILES['profile_url']['tmp_name'], "../uploads/".$fileName);
            $path = ", profile_img = '$fileName'";
        }

        $qry = "update registrations
                set fname = '$fname', mname = '$mname', lname = '$lname', age_group = '$age_group', gender = '$gender',
                dob = '$dob', sport = '$sport', sub_sport = '$sub_sport', mobile = '$mobile', email = '$email', weight = '$weight', height = '$height',
                district = '$district', taluko = '$taluko', village = '$village', caste = '$caste', g_fname = '$g_fname', g_lname = '$g_lname', g_mobile = '$g_mobile',
                c_name = '$c_name', c_mobile = '$c_mobile', c_address = '$c_address' $path where kmk_id =  '$kmk_id'";

        if(mysqli_query($con, $qry)) {            
            echo "<script>window.location.href = '$app_url/register.php?kmk_id=$kmk_id&s=1&msg=Registration%20Details%20Updated';</script>";
        }else {
            echo "<script>window.location.href = '$app_url/register.php?kmk_id=$kmk_id&e=1&msg=Failed%20To%Update%20Record';</script>";
        }
    }
?>