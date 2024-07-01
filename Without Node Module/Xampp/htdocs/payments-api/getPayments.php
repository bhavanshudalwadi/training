<?php
    require_once("db.php");

    $qry = "SELECT DATE(t.timestamp) 'date', count(t.id) 'total_transactions', sum(t.amount) 'total_collection' FROM transactions t group by DATE(t.timestamp) ORDER BY timestamp DESC";

    $result = mysqli_query($con, $qry);

    $data = [];
    if (mysqli_num_rows($result) > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $arr = [];
            $arr["date"] = date("d-m-Y", strtotime($row["date"]));
            $arr["total_collection"] = $row["total_collection"];
            $arr["total_transactions"] = $row["total_transactions"];
            
            $qry2 = "SELECT id, amount, from_upi, ref_no, TIME(timestamp) 'time' FROM `transactions` where DATE(timestamp) = '".$row["date"]."' ORDER BY timestamp DESC";
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
    }else{
        array_push($data, ["msg" => "No Records Found"]);
    }
    
    echo json_encode($data);
?>