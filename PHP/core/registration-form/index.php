<?php
    require "./parts/db.php";

    session_start();

    if(!isset($_SESSION['id'])) {
        echo "<script>window.location.href = './login.php';</script>";
    }

    $qry = "select * from registrations where id = '".$_SESSION['id']."'";
    $result = mysqli_query($con, $qry);
    $row = null;
    if(mysqli_num_rows($result)) {
        $row = mysqli_fetch_assoc($result);
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <?php require_once("parts/tscript.php"); ?>
    <title>Home | Khelmahakumbh</title>
    <link rel="stylesheet" href="./index.css" />
</head>
<body>
    <?php require("parts/header.php"); ?>
    <main class="container my-5" id="main">
        <div class="card rounded-4 bg-body-secondary" id="content">
            <div class="card-body">
                <div class="row bg-primary-subtle rounded-4 m-2 p-3">
                    <div class="col-md-12 col-lg-3">
                        <!-- <img src="./uploads/<?php echo $row['profile_img']; ?>" class="w-50 h-50 rounded-circle" /> -->
                        <h2><?php echo $row['fname']." ".$row['lname']; ?></h2>
                        <p><?php echo $row['sport'] == 1?"Football":"Race"; ?></p>
                    </div>
                    <div class="col-sm-4 col-lg-3">
                        <h6>KMK ID</h6>
                        <p><?php echo $row['kmk_id']; ?></p>
                    </div>
                    <div class="col-sm-4 col-lg-3">
                        <h6>Email Id</h6>
                        <p><?php echo $row['email']; ?></p>
                    </div>
                    <div class="col-sm-4 col-lg-3">
                        <h6>Mobile No</h6>
                        <p><?php echo $row['mobile']; ?></p>
                    </div>
                    <div class="display-sm-none col-lg-3"></div>
                    <div class="col-sm-4 col-lg-3">
                        <h6>Birth Date</h6>
                        <p><?php echo $row['dob']; ?></p>
                    </div>
                    <div class="col-sm-4 col-lg-3">
                        <h6>Guardian Name</h6>
                        <p><?php echo $row['g_fname']; ?></p>
                    </div>
                    <div class="col-sm-4 col-lg-3">
                        <h6>Coach Name</h6>
                        <p><?php echo $row['c_name']; ?></p>
                    </div>
                    <div class="col-sm-4 col-lg-3">
                        <button onclick="printRecipt(event)" class="btn btn-primary">Print Recipt</button>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <?php require("parts/footer.php"); ?>
    <?php require_once("parts/bscript.php"); ?>

    <script>
        function printRecipt(event) {
            event.target.classList.add("d-none");

            let bodyContent = document.body.innerHTML;
            let divContent = document.getElementById("content").innerHTML;
        
            document.body.innerHTML = divContent;
            window.print();
            document.body.innerHTML = bodyContent;
        }
    </script>
</body>
</html>