<?php
    print "Stage 1\n";
    assert(1 == 1);
    print "Stage 2\n";
    assert(1 == 2);
    print "Stage 3\n";
?>

<?php
    // declare(strict_types=1);

    // function sum($b) {
    //     return $b;
    // }

    // echo sum("Henil");
        if(filter_var($email, FI))
    function getBalance()
    {
        $out = 555;
        assert('is_int($out)');
        return $out;
    }

    getBalance();

    exit;
?>
<?= "Hello<br>" ?>

<?php
    // include "index2.php";
    // require "index2.php";

    // $arr[] = "Hello";
    // $arr[] = "Hello2";
    // print_r( $arr );

    // die("Terminate");
    // exit("Terminate");

    $var = '';
    if(isset($var)) {
        echo "Done";
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
<?php
    date_default_timezone_set("Asia/Kolkata");
    function sample() {
        echo func_get_arg(0);
        echo "<br>";
        print_r(func_get_args());
        echo "<br>";
        echo func_num_args();
        echo "<br>";
    }
    
    sample(1, 2, 3, "Hello", new DateTime(), [1, 2, 3]);
    
    $var = "Hello";
    $hello = "var";
    
    # refrence variable
    echo $$hello;
    echo "<br>";
    
    function call_by_ref(&$temp) {
        $temp = "World";
    }
    call_by_ref($var);
    
    echo $var;
    echo "<br>";
    
    class XYZ {
        public function __construct() {
            echo __CLASS__;
            echo "<br>";
            echo __FUNCTION__;
            echo "<br>";
            echo __METHOD__;
            echo "<br>";
            echo __LINE__;
            echo "<br>";
            echo __FILE__;
            echo "<br>";
            echo __DIR__;
        }
    }
    new XYZ();
    
    echo "<br>";
    
    $pwd = "123";
    echo md5($pwd);
    echo "<br>";
    echo password_hash($pwd, PASSWORD_DEFAULT);
    echo "<br>";
    echo crypt($pwd, md5($pwd));
    echo "<br>";
    echo sha1($pwd);
    echo "<br>";
    print_r(password_get_info(password_hash($pwd, PASSWORD_DEFAULT)));
    echo "<br>";
    var_dump(password_verify($pwd, password_hash($pwd, PASSWORD_DEFAULT)));
    echo "<br>";

    PHP_EOL;
    echo "End of php";
    
    echo "<script>let hello = ".$pwd."</script>";

?>
    <script>
        console.log(hello);

        let something = <?= $pwd ?>;
        console.log(something);
    </script>
</body>
</html>