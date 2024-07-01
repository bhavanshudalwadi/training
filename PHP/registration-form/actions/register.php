<?php
    require "../parts/db.php";
    require "../mailer/send_mail.php";

    if(isset($_POST['fname']) && filter_data($_POST['fname']) != null) {
        $kmk_id = "KMK".rand(1000000, 9999999);
        $password = generate_password();
        $kmk_type = 0;

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

        $fileName = "";
        if(isset($_FILES['profile_url'])) {
            $fileName = rand(100,999)."_".$_FILES['profile_url']['name'];
            move_uploaded_file($_FILES['profile_url']['tmp_name'], "../uploads/".$fileName);
        }

        $qry = "insert into registrations
                set kmk_id = '$kmk_id', kmk_type = '$kmk_type', fname = '$fname', mname = '$mname', lname = '$lname', age_group = '$age_group', gender = '$gender',
                dob = '$dob', sport = '$sport', sub_sport = '$sub_sport', mobile = '$mobile', email = '$email', password = '$password', weight = '$weight', height = '$height',
                district = '$district', taluko = '$taluko', village = '$village', caste = '$caste', g_fname = '$g_fname', g_lname = '$g_lname', g_mobile = '$g_mobile',
                c_name = '$c_name', c_mobile = '$c_mobile', c_address = '$c_address', profile_img = '$fileName'";

        if(mysqli_query($con, $qry)) {
            $email_result = $send_registration_email($kmk_id, $fname, $lname, $email, $password);
            if($email_result == "Mail Sent") {
                echo "<script>window.location.href = '$app_url/login.php?s=1&msg=Registration%20Sucessful';</script>";
            }else {
                $id = mysqli_insert_id($con);
                $qry = "delete from registrations where id = $id and kmk_id = '$kmk_id'";
                if(mysqli_query($con, $qry)) {
                    echo "Failed%20To%20Send%20Mail";
                    echo "<script>window.location.href = '$app_url/register.php?e=2&msg=Failed%20To%20Send%20Mail';</script>";
                }else {
                    echo "Failed%20To%20Send%20Mail%20and%20Delete%20Record";
                    echo "<script>window.location.href = '$app_url/register.php?e=3&msg=Failed%20To%20Send%20Mail%20and%20Delete%20Record';</script>";
                }
            }
        }else {
            echo "<script>window.location.href = '$app_url/register.php?e=1&msg=Failed%20To%Insert%20Record';</script>";
        }
    }
?>