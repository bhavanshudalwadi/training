<?php
    session_start();
    
    require "parts/const.php";

    if(!isset($_SESSION['admin_id'])) {
        echo "<script>window.location.href = '".app_url."/login.php';</script>";
    }

    require "classes/Castes.php";

    $mode = "Add";
    $row = null;
    if(isset($_GET['id']) && $_GET['id'] != '') {
        $mode = 'Update';
        
        $caste = new Castes();
        $result = $caste->get_by_id($_GET['id']);
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
                        <form id="regForm" action="./actions/<?php echo ($row != null)?"update-caste.php":"add-caste.php"; ?>" method="post">
                            <div class="mt-4">
                                <h5><?php echo $mode; ?> Caste</h5>
                                <hr>
                                <div class="row">
                                    <?php if($row != null): ?>
                                        <input type="hidden" name="id" value="<?php echo $_GET['id']; ?>" required>
                                    <?php endif; ?>
                                    <div class="col-md-3">
                                        <label for="name" class="form-label">Name</label>
                                        <input type="text" class="form-control" name="name" id="name" value="<?php echo ($row != null)?$row['name']:""; ?>" required>
                                    </div>
                                    <div class="col-md-3 d-flex align-items-end">
                                    </div>
                                </div>
                            <div class="mt-4">
                                <hr>
                                <div class="d-flex justify-content-end">
                                    <button class="btn btn-warning rounded-5" type="submit"><?php echo ($row != null)?"Update Caste":"Add Caste"; ?></button>
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