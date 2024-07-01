<!-- Create a HTML form that accept the user name and display the name using php -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Html Form</title>
</head>
<body>
    <form action="" method="post">
        <input type="text" name="username"/>
        <input type="submit"/>
    </form>
    <?php if(isset($_POST['username']) && $_POST['username'] != ''): ?>
        <h2><?php echo $_POST['username']; ?></h2>
    <?php endif; ?>

    <?php include("../next.php"); ?>
</body>
</html>