<?php
    session_start();
    
    require "parts/const.php";

    if(!isset($_SESSION['admin_id'])) {
        echo "<script>window.location.href = '".app_url."/login.php';</script>";
    }

    require "classes/Sports.php";
    require "classes/SubSports.php";

    $mode = "Add";
    $row = null;
    
    if(isset($_GET['id']) && $_GET['id'] != '') {
        $mode = 'Update';

        $sub_sport = new SubSports();
        $result = $sub_sport->get_by_id($_GET['id']);
        if(mysqli_num_rows($result) > 0) {
            $row = mysqli_fetch_assoc($result);
        }
    }

    $sport = new Sports();
    $result2 = $sport->get_all();
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
                        <form id="regForm" action="./actions/<?php echo ($row != null)?"update-sub-sport.php":"add-sub-sport.php"; ?>" method="post">
                            <div class="mt-4">
                                <h5><?php echo $mode; ?> Sub Sport</h5>
                                <hr>
                                <div class="row">
                                    <?php if($row != null): ?>
                                        <input type="hidden" name="id" value="<?php echo $_GET['id']; ?>" required>
                                    <?php endif; ?>
                                    <div class="col-md-3">
                                        <label for="name" class="form-label">Name</label>
                                        <input type="text" class="form-control" name="name" id="name" value="<?php echo ($row != null)?$row['name']:""; ?>" required>
                                    </div>
                                    <div class="col-md-3">
                                        <label for="sport_id" class="form-label">Sport</label>
                                        <select class="form-control selectpicker" id="sport_id" name="sport_id" required>
                                            <option value="">Select Sport</option>
                                            <?php 
                                                if(mysqli_num_rows($result2) > 0) {
                                                    while($row2 = mysqli_fetch_assoc($result2)) {
                                                        if($row != null) {
                                                            if($row['sport_id'] == $row2['id']) {
                                                                echo "<option value='".$row2['id']."' selected>".$row2['name']."</option>";
                                                            }else {
                                                                echo "<option value='".$row2['id']."'>".$row2['name']."</option>";
                                                            }
                                                        }else {
                                                            echo "<option value='".$row2['id']."'>".$row2['name']."</option>";
                                                        }
                                                    }
                                                }
                                            ?>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-4">
                                <hr>
                                <div class="d-flex justify-content-end">
                                    <button class="btn btn-warning rounded-5" type="submit"><?php echo ($row != null)?"Update Sub Sport":"Add Sub Sport"; ?></button>
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