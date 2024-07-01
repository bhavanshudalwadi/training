<?php
    require_once("db.php");

    $qry2 = "SELECT id, amount, from_upi, ref_no, timestamp FROM `transactions` ORDER BY timestamp DESC";
    $result2 = mysqli_query($con, $qry2);

    $data = [];
    if (mysqli_num_rows($result2) > 0) {
        while ($row2 = mysqli_fetch_assoc($result2)) {
            $transaction = [];
            $transaction["id"] = $row2["id"];
            $transaction["amount"] = $row2["amount"];
            $transaction["from"] = $row2["from_upi"];
            $transaction["ref_no"] = $row2["ref_no"];
            $transaction["date"] = date("d-m-Y", strtotime($row2["timestamp"]));
            $transaction["time"] = date("h:i A", strtotime($row2["timestamp"]));
            array_push($data, $transaction);
        }
    }else{
        array_push($data, ["msg" => "No Records Found"]);
    }
    
    echo json_encode($data);
?>