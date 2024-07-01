<?php
    require "./parts/db.php";

    session_start();

    if(isset($_SESSION['id'])) {
        echo "<script>window.location.href = '/registration-form/index.php';</script>";
    }
    $page_title = "Login";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <?php require_once("parts/tscript.php"); ?>
    <title>Login | Khelmahakumbh</title>
    <link rel="stylesheet" href="./index.css" />
</head>
<body>
    <?php require("parts/header.php"); ?>
    <main class="container" id="main">
        <div class="row d-flex justify-content-center">
            <div class="col-md-5">
                <div class="card my-4 shadow rounded-4">
                    <div class="card-body">
                        <form id="loginForm" action="./actions/login.php" method="post">
                            <div>
                                <h3 class="text-center">Login</h3>
                                <hr>
                                <div class="my-3">
                                    <label for="kmk_id" class="form-label">KMK ID</label>
                                    <input type="text" class="form-control" id="kmk_id" name="kmk_id">
                                </div>
                                <div class="my-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                <div class="mt-4 mb-2 d-flex justify-content-between">
                                    <div class="w-25">
                                        <button type="submit" class="btn btn-warning rounded-5 w-100">Login</button>
                                    </div>
                                    <div class="w-50 text-end">
                                        <a class="btn text-danger" href="#">Forget Password ?</a>
                                    </div>
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
    <script>
        $(document).ready(function () {
            $('#loginForm').validate({
                rules: {
                    kmk_id: {
                        required: true,
                        minlength: 10,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    },
                    password: {
                        required: true,
                        minlength: 8,
                        normalizer: function( value ) {
                            return $.trim( value );
                        }
                    }
                }
            });
        });
    </script>
</body>
</html>