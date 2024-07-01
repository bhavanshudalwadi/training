<?php 
    require "parts/const.php";
    require "classes/Category.php";

    $mode = "Add";
    $row = null;
    if(isset($_GET['id']) && $_GET['id'] != '') {
        $mode = 'Update';
        
        $category = new Category();
        $result = $category->get_by_id($_GET['id']);
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
    <title>Admin Dashboard | Products Management</title>
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
                        <form id="regForm" action="./actions/<?php echo ($row != null)?"update_category.php":"add_category.php"; ?>" method="post" enctype="multipart/form-data">
                            <div class="mt-4">
                                <h5><?php echo $mode; ?> Category</h5>
                                <hr>
                                <div class="row">
                                    <?php if($row != null): ?>
                                        <input type="hidden" name="id" value="<?php echo $_GET['id']; ?>" required>
                                    <?php endif; ?>
                                    <div class="col-md-3">
                                        <label for="name" class="form-label">Category Name</label>
                                        <input type="text" class="form-control" name="name" id="name" value="<?php echo ($row != null)?$row['name']:""; ?>" required />
                                    </div>
                                    <div class="col-md-3">
                                        <label for="img" class="form-label">Category Image</label>
                                        <input type="file" class="form-control" name="img" id="img" accept="image/*" />
                                    </div>
                                    <div class="col-md-3 text-center">
                                        <?php if($row != null): ?>
                                            <input class="form-control" type="hidden" id="old_img" name="old_img" value="<?php echo $row['img']; ?>">
                                            <img src="./uploads/categories/<?php echo $row['img']; ?>" id="preview" class="rounded-3 w-50 h-auto" />
                                        <?php else: ?>
                                            <img src="" id="preview" class="rounded-3 w-50 h-auto" />
                                        <?php endif; ?>
                                    </div>
                                    <div class="col-md-3 d-flex align-items-end">
                                    </div>
                                </div>
                            <div class="mt-4">
                                <hr>
                                <div class="d-flex justify-content-end">
                                    <button class="btn btn-warning rounded-5" type="submit"><?php echo ($row != null)?"Update Category":"Add Category"; ?></button>
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
        img.onchange = evt => {
            const [file] = img.files
            if (file) {
                preview.src = URL.createObjectURL(file)
            }
        }
    </script>
</body>
</html>