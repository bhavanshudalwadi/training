<?php
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Credentials: true');
    header('Access-Control-Max-Age: 86400');
    header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, PATCH, DELETE");
    header("Access-Control-Allow-Headers: x-access-token, Origin, X-Requested-With, Content-Type, Accept");
    
    require_once("db.php");

    // ?page=2&per_page=5
    
    $limit = "";
    if(isset($_GET["page"]) && is_numeric($_GET["page"]) && $_GET["page"] > 0) {
        $page_no = $_GET["page"];
        
        $per_page = 5;
        if(isset($_GET["per_page"]) && is_numeric($_GET["page"]) && $_GET["per_page"] > 0) {
            $per_page = $_GET["per_page"];
        }
        
        $offset = ($page_no - 1) * $per_page;
        $limit = "LIMIT $offset, $per_page";
    }
    
    $qry = "SELECT DATE(t.timestamp) 'date', count(t.id) 'total_transactions', sum(t.amount) 'total_collection' FROM transactions t group by DATE(t.timestamp) ORDER BY timestamp DESC $limit";
    $result = mysqli_query($con, $qry);

    $data = [];
    if (mysqli_num_rows($result) > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $arr = [];
            $arr["date"] = date("d-m-Y", strtotime($row["date"]));
            $arr["total_collection"] = $row["total_collection"];
            $arr["total_transactions"] = $row["total_transactions"];
            
            $qry2 = "SELECT id, amount, from_upi, ref_no, TIME(timestamp) 'time' FROM `transactions` where DATE(timestamp) = '".$row["date"]."' ORDER BY timestamp DESC LIMIT 3";
            $result2 = mysqli_query($con, $qry2);
            $arr["transactions"] = [];
            if (mysqli_num_rows($result2) > 0) {
                while ($row2 = mysqli_fetch_assoc($result2)) {
                    $transaction = [];
                    $transaction["id"] = $row2["id"];
                    $transaction["amount"] = $row2["amount"];
                    $transaction["from"] = $row2["from_upi"];
                    $transaction["ref_no"] = $row2["ref_no"];
                    $transaction["time"] = date("h:i A", strtotime($row2["time"]));
                    array_push($arr["transactions"], $transaction);
                }
            }
            array_push($data, $arr);
        }
    }
    
    echo json_encode($data);
?>