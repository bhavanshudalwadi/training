<?php
    require "parts/const.php";
    require "classes/Sports.php";

    $mode = "Add";
    $row = null;
    if(isset($_GET['id']) && $_GET['id'] != '') {
        $mode = 'Update';
        
        $sport = new Sports();
        $result = $sport->get_by_id($_GET['id']);
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
        <?php if(isset($_GET['msg'])): ?>
            <div class="alert fw-bold alert-<?= isset($_GET['e'])?"danger":"success" ?> "><?= $_GET['msg'] ?></div>
        <?php endif; ?>
        <div class="row d-flex justify-content-center">
            <div class="col-md-8">
                <div class="card h-100">
                    <div class="card-body">
                        <form id="regForm" action="./actions/<?php echo ($row != null)?"update-sport.php":"add-sport.php"; ?>" method="post">
                            <div class="mt-4">
                                <h5><?php echo $mode; ?> Sport</h5>
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
                                    <button class="btn btn-warning rounded-5" type="submit"><?php echo ($row != null)?"Update Sport":"Add Sport"; ?></button>
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