<?php
    require "./parts/db.php";

    session_start();

    if(isset($_SESSION['id'])) {
        echo "<script>window.location.href = './index.php';</script>";
    }

    $row = null;
    if(isset($_GET['kmk_id'])) {
        $page_title = "Update School/College Individual Registration";

        $qry = "select * from registrations where kmk_id = '".$_GET['kmk_id']."'";
        $result = mysqli_query($con, $qry);
        if(mysqli_num_rows($result) > 0) {
            $row = mysqli_fetch_assoc($result);
        }
    }else {
        $page_title = "School/College Individual Registration";
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <?php require_once("parts/tscript.php"); ?>
    <title>Registration | Khelmahakumbh</title>
    <link rel="stylesheet" href="./index.css" />
</head>
<body>
    <?php require("parts/header.php"); ?>
    <main class="container">
        <div class="card my-4 shadow rounded-4">
            <div class="card-body">
                <form id="regUpForm" action="" method="get">
                    <div>
                        <h5>Fetch Data From KMK ID</h5>
                        <hr>
                        <div class="row">
                            <div class="col-md-3">
                                <label for="kmk_type" class="form-label">KhelMahaKumbh</label>
                                <select class="form-select" id="kmk_type">
                                    <option value="" selected>Select Khelmahakumbh</option>
                                    <option value="1">11'th</option>
                                    <option value="2">12'th</option>
                                    <option value="3">13'th</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="kmk_id" class="form-label">KMK ID *</label>
                                <input type="text" class="form-control" id="kmk_id" name="kmk_id" placeholder="KMK0000000">
                            </div>
                            <div class="col-md-3 d-flex align-items-end">
                                <button type="submit" class="btn btn-warning rounded-5">Search</button>
                            </div>
                        </div>
                    </div>
                </form>
                <form id="regForm" action="./actions/<?php echo ($row != null)?"update-register.php":"register.php"; ?>" method="post" enctype="multipart/form-data">
                    <div class="mt-4">
                        <h5>Player Details</h5>
                        <hr>
                        <?php if(isset($_GET["s"])): ?>
                            <div class="alert alert-success" role="alert">
                                <?= $_GET["msg"] ?>
                            </div>
                        <?php elseif(isset($_GET["e"])): ?>
                            <div class="alert alert-danger" role="alert">
                                <?= $_GET["msg"] ?>
                            </div>
                        <?php endif; ?>
                        <div class="row">
                            <?php if($row != null): ?>
                                <input type="hidden" name="kmk_id" value="<?php echo $row['kmk_id']; ?>" required>
                            <?php endif; ?>
                            <div class="col-md-3">
                                <label for="fname" class="form-label">First Name *</label>
                                <input type="text" class="form-control" name="fname" id="fname" value="<?php echo ($row != null)?$row['fname']:""; ?>" required>
                            </div>
                            <div class="col-md-3">
                                <label for="mname" class="form-label">Father/Husband Name *</label>
                                <input type="text" class="form-control" name="mname" id="mname" value="<?php echo ($row != null)?$row['mname']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="lname" class="form-label">Last Name *</label>
                                <input type="text" class="form-control" id="lname" name="lname" value="<?php echo ($row != null)?$row['lname']:""; ?>" required>
                            </div>
                            <div class="col-md-3">
                                <label for="age_group" class="form-label">Age Group *</label>
                                <select class="form-control selectpicker" id="age_group" name="age_group" required>
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['age_group']) {
                                                case "1": echo "<option value='1' selected>06 to 14 year</option>
                                                            <option value='2'>15 to 20 year</option>
                                                            <option value='3'>21 to 59 year</option>
                                                            <option value='4'>Above 60</option>";
                                                            break;
                                                case "2": echo "<option value='1'>06 to 14 year</option>
                                                            <option value='2' selected>15 to 20 year</option>
                                                            <option value='3'>21 to 59 year</option>
                                                            <option value='4'>Above 60</option>";
                                                            break;
                                                case "3": echo "<option value='1'>06 to 14 year</option>
                                                            <option value='2'>15 to 20 year</option>
                                                            <option value='3' selected>21 to 59 year</option>
                                                            <option value='4'>Above 60</option>";
                                                            break;
                                                case "4": echo "<option value='1'>06 to 14 year</option>
                                                            <option value='2'>15 to 20 year</option>
                                                            <option value='3'>21 to 59 year</option>
                                                            <option value='4' selected>Above 60</option>";
                                                            break;
                                                default: echo "<option value='1'>06 to 14 year</option>
                                                            <option value='2'>15 to 20 year</option>
                                                            <option value='3'>21 to 59 year</option>
                                                            <option value='4'>Above 60</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value="1">06 to 14 year</option>
                                        <option value="2">15 to 20 year</option>
                                        <option value="3">21 to 59 year</option>
                                        <option value="4">Above 60</option>
                                    <?php endif; ?>
                                </select>
                            </div>
                            <div class="col-md-3 radio-container">
                                <label for="gender" class="form-label">Select Gender *</label>
                                <div class="d-flex">
                                    <div class="form-check me-2">
                                        <input class="form-check-input" type="radio" name="gender" id="male" value="0" <?php echo ($row != null)?(($row['gender'] == "0")?"checked":""):""; ?>>
                                        <label class="form-check-label" for="male">
                                            Male
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="gender" id="female" value="1" <?php echo ($row != null)?(($row['gender'] == "1")?"checked":""):""; ?>>
                                        <label class="form-check-label" for="female">
                                            Female
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <label for="dob" class="form-label">Date of Birth (DD-MM-YYYY) *</label>
                                <input type="date" class="form-control" min='1899-01-01' max='2018-12-31' name="dob" id="dob" value="<?php echo ($row != null)?$row['dob']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="sport" class="form-label">Sports Name *</label>
                                <select class="form-select" id="sport" name="sport" required>
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['sport']) {
                                                case "1": echo "<option value='1' selected>Football</option>
                                                                <option value='2'>Race</option>";
                                                            break;
                                                case "2": echo "<option value='1'>Football</option>
                                                                <option value='2' selected>Race</option>";
                                                            break;
                                                default: echo "<option value='1'>Football</option>
                                                                <option value='2'>Race</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value='1'>Football</option>
                                        <option value='2'>Race</option>
                                    <?php endif; ?>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="sub_sport" class="form-label">Sub Sports Name *</label>
                                <select class="form-select" id="sub_sport" name="sub_sport" required>
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['sub_sport']) {
                                                case "1": echo "<option value='1' selected>100M Race</option>
                                                                <option value='2'>500M Race</option>
                                                                <option value='3'>1000M Race</option>";
                                                            break;
                                                case "2": echo "<option value='1'>100M Race</option>
                                                                <option value='2' selected>500M Race</option>
                                                                <option value='3'>1000M Race</option>";
                                                            break;
                                                case "3": echo "<option value='1'>100M Race</option>
                                                                <option value='2' selected>500M Race</option>
                                                                <option value='3' selected>1000M Race</option>";
                                                            break;
                                                default: echo "<option value='1'>100M Race</option>
                                                                <option value='2'>500M Race</option>
                                                                <option value='3'>1000M Race</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value='1'>Football</option>
                                        <option value='2'>Race</option>
                                    <?php endif; ?>
                                </select>
                            </div>
                            <!-- <div class="col-md-3">
                                <label class="form-label" for="select_another_game">
                                    Tick the check  box to select another game
                                </label>
                                <input class="form-check-input" type="checkbox" value="" id="select_another_game">
                            </div> -->
                            <div class="col-md-3">
                                <label for="mobile" class="form-label">Mobile Number *</label>
                                <input type="number" maxlength="10" min="0" class="form-control" pattern="^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$" name="mobile" id="mobile" value="<?php echo ($row != null)?$row['mobile']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="email" class="form-label">Email *</label>
                                <input type="email" class="form-control" name="email" id="email" value="<?php echo ($row != null)?$row['email']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="weight" class="form-label">Weight (kg)</label>
                                <input type="number" min="20" max="1000" class="form-control" name="weight" id="weight" value="<?php echo ($row != null)?$row['weight']:""; ?>"/>
                            </div>
                            <div class="col-md-3">
                                <label for="height" class="form-label">Height (cm)</label>
                                <input type="number" min="92" max="272" class="form-control" name="height" id="height" value="<?php echo ($row != null)?$row['height']:""; ?>"/>
                            </div>
                            <div class="col-md-3">
                                <label for="district" class="form-label">District</label>
                                <select class="form-select" id="district" name="district">
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['district']) {
                                                case "1": echo "<option value='1' selected>Bhavnagar</option>
                                                                <option value='2'>Ahemedabad</option>
                                                                <option value='3'>Jamnagar</option>";
                                                            break;
                                                case "2": echo "<option value='1'>Bhavnagar</option>
                                                                <option value='2' selected>Ahemedabad</option>
                                                                <option value='3'>Jamnagar</option>";
                                                            break;
                                                case "3": echo "<option value='1'>Bhavnagar</option>
                                                                <option value='2'>Ahemedabad</option>
                                                                <option value='3' selected>Jamnagar</option>";
                                                            break;
                                                default: echo "<option value='1'>Bhavnagar</option>
                                                                <option value='2'>Ahemedabad</option>
                                                                <option value='3'>Jamnagar</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value='1'>Bhavnagar</option>
                                        <option value='2'>Ahemedabad</option>
                                        <option value='3'>Jamnagar</option>
                                    <?php endif; ?>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="taluko" class="form-label">Taluka/Zone</label>
                                <select class="form-select" id="taluko" name="taluko">
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['taluko']) {
                                                case "1": echo "<option value='1' selected>Bhavnagar</option>
                                                                <option value='2'>Mahuva</option>
                                                                <option value='3'>Palitana</option>";
                                                            break;
                                                case "2": echo "<option value='1'>Bhavnagar</option>
                                                                <option value='2' selected>Mahuva</option>
                                                                <option value='3'>Palitana</option>";
                                                            break;
                                                case "3": echo "<option value='1'>Bhavnagar</option>
                                                                <option value='2'>Mahuva</option>
                                                                <option value='3' selected>Palitana</option>";
                                                            break;
                                                default: echo "<option value='1'>Bhavnagar</option>
                                                                <option value='2'>Mahuva</option>
                                                                <option value='3'>Palitana</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value='1'>Bhavnagar</option>
                                        <option value='2'>Mahuva</option>
                                        <option value='3'>Palitana</option>
                                    <?php endif; ?>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="village" class="form-label">Village/Ward</label>
                                <select class="form-select" id="village" name="village">
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['village']) {
                                                case "1": echo "<option value='1' selected>Adhevada</option>
                                                                <option value='2'>Sidsar</option>
                                                                <option value='3'>Ghogha</option>";
                                                            break;
                                                case "2": echo "<option value='1'>Adhevada</option>
                                                                <option value='2' selected>Sidsar</option>
                                                                <option value='3'>Ghogha</option>";
                                                            break;
                                                case "3": echo "<option value='1'>Adhevada</option>
                                                                <option value='2'>Sidsar</option>
                                                                <option value='3' selected>Ghogha</option>";
                                                            break;
                                                default: echo "<option value='1'>Adhevada</option>
                                                                <option value='2'>Sidsar</option>
                                                                <option value='3'>Ghogha</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value='1'>Adhevada</option>
                                        <option value='2'>Sidsar</option>
                                        <option value='3'>Ghogha</option>
                                    <?php endif; ?>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="caste" class="form-label">Caste *</label>
                                <select class="form-select" id="caste" name="caste">
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['caste']) {
                                                case "1": echo "<option value='1' selected>General</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4'>ST</option>";
                                                            break;
                                                case "2": echo "<option value='1'>General</option>
                                                                <option value='2' selected>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4'>ST</option>";
                                                            break;
                                                case "3": echo "<option value='1'>General</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3' selected>SC</option>
                                                                <option value='4'>ST</option>";
                                                            break;
                                                case "4": echo "<option value='1'>General</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4' selected>ST</option>";
                                                            break;
                                                default: echo "<option value='1'>General</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4'>ST</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value='1'>General</option>
                                        <option value='2'>OBC</option>
                                        <option value='3'>SC</option>
                                        <option value='4'>ST</option>
                                    <?php endif; ?>
                                </select>
                            </div>

                            <div class="col-md-3">
                                <label for="profile_url" class="form-label">Profile Image</label>
                                <input class="form-control" type="file" id="profile_url" name="profile_url" accept="image/png, image/jpg, image/jpeg">
                            </div>
                            <div class="col-md-3 text-center">
                                <?php if($row != null): ?>
                                    <?php if(file_exists("./uploads/".$row['profile_img'])): ?>
                                        <input class="form-control" type="hidden" id="old_profile" name="old_profile" value="<?php echo $row['profile_img']; ?>">
                                        <img src="./uploads/<?php echo $row['profile_img']; ?>" id="preview" class="rounded-3 w-50 h-auto" />
                                    <?php else: ?>
                                        <img id="preview" class="rounded-3 w-50 h-auto" />
                                    <?php endif; ?>
                                <?php else: ?>
                                    <img id="preview" class="rounded-3 w-50 h-auto" />
                                <?php endif; ?>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4">
                        <h5>Guardians Details</h5>
                        <hr>
                        <div class="row">
                            <div class="col-md-3">
                                <label for="g_fname" class="form-label">First Name</label>
                                <input type="text" class="form-control" name="g_fname" id="g_fname" value="<?php echo ($row != null)?$row['g_fname']:""; ?>">
                            </div>
                            <div class="col-md-3">
                                <label for="g_lname" class="form-label">Last Name</label>
                                <input type="text" class="form-control" name="g_lname" id="g_lname" value="<?php echo ($row != null)?$row['g_lname']:""; ?>">
                            </div>
                            <div class="col-md-3">
                                <label for="g_mobile" class="form-label">Mobile</label>
                                <input type="text" class="form-control" name="g_mobile" pattern="^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$" id="g_mobile" value="<?php echo ($row != null)?$row['g_mobile']:""; ?>"/>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4">
                        <h5>Other Details</h5>
                        <hr>
                        <div class="row">
                            <div class="col-md-3">
                                <label for="c_name" class="form-label">Coach Name</label>
                                <input type="text" class="form-control" name="c_name" id="c_name" value="<?php echo ($row != null)?$row['c_name']:""; ?>">
                            </div>
                            <div class="col-md-3">
                                <label for="c_mobile" class="form-label">Coach Mobile</label>
                                <input type="tel" class="form-control" pattern="^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$" name="c_mobile" id="c_mobile" value="<?php echo ($row != null)?$row['c_mobile']:""; ?>">
                            </div>
                            <div class="col-md-3">
                                <label for="c_address" class="form-label">Coach Home Address</label>
                                <textarea class="form-control" id="c_address" name="c_address" rows="1"><?php echo ($row != null)?$row['c_address']:""; ?></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4">
                        <hr>
                        <div class="row">
                            <div class="col-md-12">
                                <=== Captcha Verification ===>
                            </div>
                            <div class="col-md-12">
                                <b>Note - You Will recive the login ID and password information of the player in the above email</b>
                            </div>
                            <div class="col-md-12">
                                <p>
                                    1. If any kind of physical injury happens during the competition, it will be the responsibility of me and my guardian. The organizer will have no responsibility <br>
                                    2. I will register from one place from the entire state, otherwise my registration will be canceled. <br>
                                    3. Therefore, I ______________________________________________________________________________ <br>
                                    guarantee that if I am selected as the winner in Khelmahakumbh, I will be present at the competition venue at my own expense and risk before the time indicated. <br>
                                    4. Mark the event on the back page <i class="bi bi-check-lg fs-4 fw-bold"></i> for each individual sub-event game. <br>
                                    5. Form-A for individual sport and Form-A and Form B for joint sport are mandatory to be filled. <br>
                                    6. Form-B must be filled for Table Tennis, Lawn Tennis, Badminton Doubles and Mixed Doubles.
                                </p>
                            </div>
                            <div class="col-md-12">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="select_another_game">
                                    <label class="form-label" for="select_another_game">
                                        I Accept
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4">
                        <hr>
                        <div class="d-flex justify-content-end">
                            <button class="btn btn-warning rounded-5" type="submit"><?php echo ($row != null)?"Update Details":"Register"; ?></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <?php require("parts/footer.php"); ?>
    <?php require_once("parts/bscript.php"); ?>
    <script>
        $(document).ready(function () {
            $.validator.addMethod('filesize', function(value, element, param) {
                return this.optional(element) || (element.files[0].size <= param)
            });

            $('#regForm').validate({
                rules: {
                    fname: {
                        required: true,
                        minlength: 3,
                        maxlength: 255,
                        lettersonly: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    mname: {
                        required: true,
                        minlength: 1,
                        maxlength: 255,
                        lettersonly: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    lname: {
                        required: true,
                        minlength: 3,
                        maxlength: 255,
                        lettersonly: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    age_group: {
                        required: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    gender: {
                        required: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    dob: {
                        required: true,
                        date : true,
                        // dateITA : true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    sport: {
                        required: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    c_name: {
                        lettersonly: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    sub_sport: {
                        required: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    mobile: {
                        required: true,
                        // phoneUS: true,
                        number: true,
                        minlength: 10,
                        maxlength: 10,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    email: {
                        required: true,
                        email: true,
                        minlength: 6,
                        maxlength: 255,
                        // regex: /^\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    caste: {
                        required: true,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    profile_img: {
                        required: true,
                        extension: "png|jpe?g",
                        filesize: 1
                    }
                },
                messages: {
                    fname: {
                        required: "First Name is required",
                        minlength: "First Name should be atleast 3 charecters long"
                    },
                    mname: {
                        required: "Middle Name is required"
                    },
                    lname: {
                        required: "Last Name is required",
                        minlength: "Last Name should be atleast 3 charecters long"
                    },
                    age_group: {
                        required: "Please select age group"
                    },
                    gender: {
                        required: "select your gender"
                    },
                    dob: {
                        required: "Date of birth is required"
                    },
                    sport: {
                        required: "Please Select Sport"
                    },
                    sub_sport: {
                        required: "Please select sub sport"
                    },
                    mobile: {
                        required: "Mobile number is required",
                        minlength: "Invalid Mobile Number",
                        maxlength: "Invalid Mobile Number",
                        pattern: "Invalid Mobile Number"
                    },
                    email: {
                        required: "We need your email address to contact you",
                        email: "Your email address must be in the format of name@domain.com",
                        minlength: "Invalid email address",
                    },
                    weight: {
                        min: "Weight should be atleast 20 Kg",
                        max: "Weight can't be more than 1000 Kg"
                    },
                    height: {
                        min: "Height should be atleast 92 cm",
                        max: "Height can't be more than 272 cm"
                    },
                    caste: {
                        required: "Please select caste"
                    },
                    profile_img: {
                        required: "Profile Image is required",
                        extension: "Invalid Image Formate"
                    }
                },
                errorPlacement: function(error, element) {
                    if ( element.is(":radio") ) {
                        error.appendTo( element.parents('.radio-container') );
                    }else {
                        error.insertAfter( element );
                    }
                }
            });

            $('#regUpForm').validate({
                rules: {
                    kmk_id: {
                        required: true,
                        minlength: 10
                    }
                }
            });

            // $("#profile_url").on('change', function (e) {
            //     let file = this.files[0];
            //     if (file) {
            //         let reader = new FileReader();
            //         reader.onload = function (event) {
            //             $("#preview").attr("src", event.target.result);
            //         };
            //         reader.readAsDataURL(file);
            //     }
            // });
        });

        profile_url.onchange = evt => {
            const [file] = profile_url.files
            if (file) {
                preview.src = URL.createObjectURL(file)
            }
        }
    </script>
</body>
</html>