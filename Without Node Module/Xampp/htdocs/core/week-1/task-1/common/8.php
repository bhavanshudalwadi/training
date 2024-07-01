<!-- Write a PHP script to display string, values within a table -->
<?php
    // $memcached = new Memcached();
    // $memcached->addServer('localhost', 11211);

    session_start();
    // session_destroy();
  
    $data = [];
    if(!isset($_SESSION['data'])) {
        $_SESSION['data'] = [];
    }
    $data = $_SESSION['data'];

    // $cache = $memcached->get('data');
    // if(!isset($cache)) {
    //     $memcached->set('data', []);
    // }
    // $data = $memcached->get('data');

    if(isset($_POST['name']) && $_POST['name'] != '') {
        array_push($data, ["name" => $_POST['name'], "email" => $_POST['email'], "phone" => $_POST['phone']]);
        $_SESSION['data'] = $data;
        // $memcached->set('data', $data);
    }

?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=0.9">
        <title>PHP Table Display</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
    <div class="container mt-4">
        <div class="d-flex justify-content-center my-4">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body text-center">
                        <h2>Enter Form Details</h2>
                        <form action="" method="post">
                            <input class="form-control my-3" type="text" name="name" placeholder = "Enter Your Name"/>
                            <input class="form-control my-3" type="email" name="email" placeholder = "Enter Your Email"/>
                            <input class="form-control my-3" type="tel" name="phone" placeholder = "Enter Your Phone"/>
                            <input class="btn btn-primary w-25" type="submit" value="Add" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <?php
            echo "<table style='box-sizing: border-box' class='table table-striped table-hover'><tr class='table-dark'><th>Name</th><th>Email</th><th>Phone</th></tr>";
            foreach($data as $key1 => $item) {
                echo "<tr><td>".$item['name']."</td><td>".$item['email']."</td><td>".$item['phone']."</td></tr>";
            }
            echo "</table>";
        ?>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
