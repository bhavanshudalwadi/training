<?php
    require_once __DIR__ . '/vendor/autoload.php';

    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\SMTP;
    use PHPMailer\PHPMailer\Exception;

    $mail = new PHPMailer(true);

    $mail->SMTPDebug = 2;
    $mail->isSMTP();
    $mail->Host	 = 'smtp.gmail.com';
    $mail->SMTPAuth = true;
    $mail->SMTPDebug = 0;
    $mail->Username = 'bhavanshu.programer@gmail.com';
    $mail->Password = 'rpdb sgco oznc xfhi';
    $mail->SMTPSecure = 'tls';
    $mail->Port	 = 587;

    $mail->SMTPOptions = array(
        'ssl' => array(
            'verify_peer' => false,
            'verify_peer_name' => false,
            'allow_self_signed' => true
        )
    );

    $send_registration_email = function($kmk_id, $fname, $lname, $email, $password) use ($mail) {
        $mail->setFrom('bhavanshu.programer@gmail.com', 'Khelmahakumbh');
        $mail->addAddress($email, $fname." ".$lname);

        $mail->isHTML(true);
        $mail->Subject = 'Khelmahakumbh Registration Successful';

        $bodyContent = '<h1>Welcome to Khelmahakumbh</h1>';
        $bodyContent .= '<h2>Hello, '.$fname.' '.$lname.'</h2>';
        $bodyContent .= '<h3>Your Khelmahakumbh login details are as follow:</h3>';
        $bodyContent .= '<p>KMK ID: <b>'.$kmk_id.'</b></p>';
        // $bodyContent .= '<p>Email: <b>'.$email.'</b></p>';
        $bodyContent .= '<p>Password: <b>'.$password.'</b></p>';

        $mail->Body = $bodyContent;
        $mail->AltBody = 'Not Suported';

        if(!$mail->send()) {
            return 'Message could not be sent. Mailer Error: '.$mail->ErrorInfo;
        } else {
            return 'Mail Sent';
        }
    }
?>