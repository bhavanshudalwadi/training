<?php
    session_start();
    
    require "parts/const.php";

    if(!isset($_SESSION['admin_id'])) {
        echo "<script>window.location.href = '".app_url."/login.php';</script>";
    }

    require "classes/Players.php";

    $mode = "Add";
    $row = null;
    if(isset($_GET['id']) && $_GET['id'] != '') {
        $mode = 'Update';
        
        $player = new Players();
        $result = $player->get_by_id($_GET['id']);
        if(mysqli_num_rows($result) > 0) {
            $row = mysqli_fetch_assoc($result);
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <?php require_once("parts/tscript.php"); ?>
    <title>Admin Dashboard | Khelmahakumbh</title>
    <link rel="stylesheet" href="./index.css" />
</head>
<body>
    <?php require("parts/header.php"); ?>
    <main class="container-fluid my-4" id="main">
        <div class="row">
            <div class="col-2">
                <?php require_once "parts/sidebar.php"; ?>
            </div>
            <div class="col-10">
                <div class="card h-100">
                    <div class="card-body">
                    <form id="regForm" action="./actions/<?php echo ($row != null)?"update-player.php":"add-player.php"; ?>" method="post">
                    <div class="mt-4">
                        <h5><?php echo $mode; ?> Player</h5>
                        <hr>
                        <div class="row">
                            <?php if($row != null): ?>
                                <input type="hidden" name="id" value="<?php echo $_GET['id']; ?>" required>
                            <?php endif; ?>
                            <div class="col-md-3">
                                <label for="fname" class="form-label">First Name</label>
                                <input type="text" class="form-control" name="fname" id="fname" value="<?php echo ($row != null)?$row['fname']:""; ?>" required>
                            </div>
                            <div class="col-md-3">
                                <label for="mname" class="form-label">Father/Husband Name</label>
                                <input type="text" class="form-control" name="mname" id="mname" value="<?php echo ($row != null)?$row['mname']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="lname" class="form-label">Last Name</label>
                                <input type="text" class="form-control" id="lname" name="lname" value="<?php echo ($row != null)?$row['lname']:""; ?>" required>
                            </div>
                            <div class="col-md-3">
                                <label for="age_group" class="form-label">Age Group</label>
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
                                <label for="gender" class="form-label">Select Gender</label>
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
                                <label for="dob" class="form-label">Date of Birth (DD-MM-YYYY)</label>
                                <input type="date" class="form-control" name="dob" id="dob" value="<?php echo ($row != null)?$row['dob']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="sport" class="form-label">Sports Name</label>
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
                                <label for="sub_sport" class="form-label">Sub Sports Name</label>
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
                            <div class="col-md-3">
                                <label for="mobile" class="form-label">Mobile Number</label>
                                <input type="tel" class="form-control" name="mobile" id="mobile" value="<?php echo ($row != null)?$row['mobile']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" name="email" id="email" value="<?php echo ($row != null)?$row['email']:""; ?>" required/>
                            </div>
                            <div class="col-md-3">
                                <label for="weight" class="form-label">Weight (kg)</label>
                                <input type="number" class="form-control" name="weight" id="weight" min="0" max="999" value="<?php echo ($row != null)?$row['weight']:""; ?>"/>
                            </div>
                            <div class="col-md-3">
                                <label for="height" class="form-label">Height (cm)</label>
                                <input type="number" class="form-control" name="height" id="height" min="0" max="999" value="<?php echo ($row != null)?$row['height']:""; ?>"/>
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
                                <label for="caste" class="form-label">Caste</label>
                                <select class="form-select" id="caste" name="caste">
                                    <option value="">Select</option>
                                    <?php if($row != null): ?>
                                        <?php
                                            switch($row['caste']) {
                                                case "1": echo "<option value='1' selected>Genral</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4'>ST</option>";
                                                            break;
                                                case "2": echo "<option value='1'>Genral</option>
                                                                <option value='2' selected>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4'>ST</option>";
                                                            break;
                                                case "3": echo "<option value='1'>Genral</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3' selected>SC</option>
                                                                <option value='4'>ST</option>";
                                                            break;
                                                case "4": echo "<option value='1'>Genral</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4' selected>ST</option>";
                                                            break;
                                                default: echo "<option value='1'>Genral</option>
                                                                <option value='2'>OBC</option>
                                                                <option value='3'>SC</option>
                                                                <option value='4'>ST</option>";
                                            }
                                        ?>
                                    <?php else: ?>
                                        <option value='1'>Genral</option>
                                        <option value='2'>OBC</option>
                                        <option value='3'>SC</option>
                                        <option value='4'>ST</option>
                                    <?php endif; ?>
                                </select>
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
                                <input type="text" class="form-control" name="g_mobile" id="g_mobile" value="<?php echo ($row != null)?$row['g_mobile']:""; ?>"/>
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
                                <input type="tel" class="form-control" name="c_mobile" id="c_mobile" value="<?php echo ($row != null)?$row['c_mobile']:""; ?>">
                            </div>
                            <div class="col-md-3">
                                <label for="c_address" class="form-label">Coach Home Address</label>
                                <textarea class="form-control" id="c_address" name="c_address" rows="1"><?php echo ($row != null)?$row['c_address']:""; ?></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4">
                        <hr>
                        <div class="d-flex justify-content-end">
                            <button class="btn btn-warning rounded-5" type="submit"><?php echo ($row != null)?"Update Details":"Add Player"; ?></button>
                        </div>
                    </div>
                </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <?php require("parts/footer.php"); ?>
    <?php require_once("parts/bscript.php"); ?>
</body>
</html>