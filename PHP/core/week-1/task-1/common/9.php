<?php
    // Write a PHP function to test whether a number is greater than 30, 20 or 10 using ternary operator

    $msg = "";

    if(isset($_POST['number']) && $_POST['number'] != '' && is_numeric($_POST['number'])) {
        $msg = $_POST['number'] > 30?"Number Is > 30":($_POST['number'] > 20?"Number Is > 20":($_POST['number'] > 10?"Number Is > 10":"Number Is < 10"));
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ternary Oprator Example</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-4">
        <div class="d-flex justify-content-center my-4">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body text-center">
                        <h2>Number Check</h2>
                        <?php if($msg != ''): ?>
                        <div class="alert alert-success" role="alert">
                            <?php echo $msg; ?>
                        </div>
                        <?php endif; ?>
                        <form action="" method="post">
                            <input class="form-control my-3" type="number" name="number" placeholder = "Enter Number"/>
                            <input class="btn btn-primary w-25" type="submit" value="Test" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>