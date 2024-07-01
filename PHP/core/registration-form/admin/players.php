<?php
    session_start();
    
    require "parts/const.php";

    if(!isset($_SESSION['admin_id'])) {
        echo "<script>window.location.href = '".app_url."/login.php';</script>";
    }

    require "classes/Players.php";

    $player = new Players();

    $page = isset($_GET['page'])?$_GET['page']:1;
    $records_per_page = isset($_GET['per_page'])?$_GET['per_page']:5;

    $result = $player->get_by_page($page, $records_per_page);
    $count = $player->get_count();
    $pages = ceil($count/$records_per_page);
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
                        <div class="row mt-2 mb-3">
                            <div class="col-md-6">
                                <h4>Player List</h4>
                            </div>
                            <div class="col-md-6 d-flex justify-content-end">
                                <a href="<?php echo app_url; ?>/edit-player.php" class="btn btn-primary">Add Player</a>
                            </div>
                        </div>
                        <table class="table table-striped table-hover">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col">DOB</th>
                                    <th scope="col">Sport</th>
                                    <th scope="col">Sub Sport</th>
                                    <th scope="col">Mobile</th>
                                    <th scope="col">Weight</th>
                                    <th scope="col">Height</th>
                                    <th scope="col">District</th>
                                    <th scope="col">Taluko</th>
                                    <th scope="col">Village</th>
                                    <th scope="col">Guardian</th>
                                    <th scope="col">Coach</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php if($count > 0): ?>
                                <?php while($row = mysqli_fetch_assoc($result)): ?>
                                    <tr>
                                        <th scope="row"><?php echo $row['id']; ?></th>
                                        <td><?php echo $row['fname']." ".$row['lname']; ?></td>
                                        <td><?php echo $row['gender']=="0"?"Male":"Female"; ?></td>
                                        <td><?php echo $row['dob']; ?></td>
                                        <td><?php echo $row['sport']; ?></td>
                                        <td><?php echo $row['sub_sport']; ?></td>
                                        <td><?php echo $row['mobile']; ?></td>
                                        <td><?php echo $row['weight']; ?></td>
                                        <td><?php echo $row['height']; ?></td>
                                        <td><?php echo $row['district']; ?></td>
                                        <td><?php echo $row['taluko']; ?></td>
                                        <td><?php echo $row['village']; ?></td>
                                        <td><?php echo $row['g_fname']." ".$row['g_lname']; ?></td>
                                        <td><?php echo $row['c_name']; ?></td>
                                        <td>
                                            <a href="<?php echo app_url; ?>/edit-player.php?id=<?php echo $row['id']; ?>" class="btn btn-outline-success">Edit</a>
                                            <a href="javascript: deletePlayer('<?php echo $row['fname']." ".$row['lname']; ?>', <?php echo $row['id']; ?>)" class="btn btn-outline-danger">Delete</a>
                                        </td>
                                    </tr>
                                <?php endwhile; ?>
                                <?php endif; ?>
                            </tbody>
                        </table>
                        <nav aria-label="Page navigation" class="d-flex justify-content-between">
                            <div class="d-flex align-items-center">
                                <h5 class="m-0" style="width: 100px">Per Page</h5>
                                <select id="per_page" class="form-select" style="width: 100px">
                                    <?php
                                        switch($records_per_page) {
                                            case "5": echo "<option value='5' selected>5</option>
                                                            <option value='10'>10</option>
                                                            <option value='15'>15</option>
                                                            <option value='20'>20</option>";
                                                        break;
                                            case "10": echo "<option value='5'>5</option>
                                                            <option value='10' selected>10</option>
                                                            <option value='15'>15</option>
                                                            <option value='20'>20</option>";
                                                        break;
                                            case "15": echo "<option value='5'>5</option>
                                                            <option value='10'>10</option>
                                                            <option value='15' selected>15</option>
                                                            <option value='20'>20</option>";
                                                        break;
                                            case "20": echo "<option value='5'>5</option>
                                                            <option value='10'>10</option>
                                                            <option value='15'>15</option>
                                                            <option value='20' selected>20</option>";
                                                        break;
                                            default: echo "<option value='5'>5</option>
                                                            <option value='10'>10</option>
                                                            <option value='15'>15</option>
                                                            <option value='20'>20</option>";
                                        }
                                    ?>
                                </select>
                            </div>
                            <ul class="pagination justify-content-end m-0">
                                <li class="page-item"><a class="page-link <?php echo ($page <= 1)?"disabled":""; ?>" href="<?php echo ($page > 1)?app_url."/players.php?page=".($page-1)."&per_page=".$records_per_page:"#"; ?>">Previous</a></li>
                                <?php foreach(range(1, $pages) as $p): ?>
                                    <li class="page-item"><a class="page-link" href="<?php echo app_url; ?>/players.php?page=<?php echo $p; ?>&per_page=<?php echo $records_per_page; ?>"><?php echo $p; ?></a></li>
                                <?php endforeach; ?>
                                <li class="page-item"><a class="page-link <?php echo ($page >= $pages)?"disabled":""; ?>" href="<?php echo ($page < $pages)?app_url."/players.php?page=".($page+1)."&per_page=".$records_per_page:"#"; ?>">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <?php require("parts/footer.php"); ?>
    <?php require_once("parts/bscript.php"); ?>
    <script>
        $("#per_page").on('change', function() {
			let per_page = $(this).val();
			
            window.location.href = `<?php echo app_url; ?>/players.php?page=1&per_page=${per_page}`;
		});

        function deletePlayer(name, id) {
            if(confirm(`Are you sure want to delete player named \`${name}\``)) {
                window.location.href = `<?php echo app_url; ?>/actions/delete-player.php?id=${id}`;
            }
        }
    </script>
</body>
</html>