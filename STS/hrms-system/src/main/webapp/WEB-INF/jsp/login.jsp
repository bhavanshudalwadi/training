<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <title>Login | HRMS</title>

   <link rel="shortcut icon" type="image/png" href="assets/images/favicon.png" />

    <link href="/assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="/assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="/assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/lib/helper.css" rel="stylesheet">
    <link href="/assets/css/style.css" rel="stylesheet">
    
    <link href="/assets/css/lib/toastr/toastr.min.css" rel="stylesheet">
</head>

<body class="bg-dark">

    <div class="unix-login">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-5">
                    <div class="login-content">
                        <div class="login-form" style="border-radius: 20px; text-align: center">
                        	<img class="icon" src="/assets/images/silvertouch-icon.png" alt=""/>
                        	<h4 class="text-center">Human Resource Management System</h4>
                            <h3 class="text-center mb-4">HRMS Login</h3>
                            <form action="/login" method="post">
                                <div class="form-group">
                                    <input type="email" name="username" id="username" style="border-radius: 10px" class="form-control" placeholder="Email" required>
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" style="border-radius: 10px" class="form-control" placeholder="Password" required>
                                </div>
<!--                                 <div class="checkbox"> -->
<!--                                     <label> -->
<!-- 										<input type="checkbox"> Remember Me -->
<!-- 									</label> -->
<!--                                     <label class="pull-right"> -->
<!-- 										<a href="#">Forgotten Password?</a> -->
<!-- 									</label> -->
<!--                                 </div> -->
                                <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-10" style="border-radius: 10px" onclick="return checkValidation()">Sign in</button>
                                <div class="register-link m-t-15 text-center">
                                    <p>Don't have account ? <a href="/restaurantRegistration"> Sign Up Here</a></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/assets/js/lib/toastr/toastr.min.js"></script>
	<script>
		function checkValidation() {
			let username = $("#username").val();
			let password = $("#password").val();
			
			if(username == '' || password == '') {
				 toastr.error('Please Enter Valid Login Details !!','Invalid Inputs',{
			        "positionClass": "toast-top-right",
			        timeOut: 3000,
			        "closeButton": false,
			        "debug": false,
			        "newestOnTop": true,
			        "progressBar": true,
			        "preventDuplicates": true,
			        "onclick": null,
			        "showDuration": "300",
			        "hideDuration": "1000",
			        "extendedTimeOut": "1000",
			        "showEasing": "swing",
			        "hideEasing": "linear",
			        "showMethod": "fadeIn",
			        "hideMethod": "fadeOut",
			        "tapToDismiss": false
			    });
			 	return false;
			}else if(!IsEmail(username)) {
				toastr.error('Please Enter Valid Email !!','Invalid Inputs',{
			        "positionClass": "toast-top-right",
			        timeOut: 3000,
			        "closeButton": false,
			        "debug": false,
			        "newestOnTop": true,
			        "progressBar": true,
			        "preventDuplicates": true,
			        "onclick": null,
			        "showDuration": "300",
			        "hideDuration": "1000",
			        "extendedTimeOut": "1000",
			        "showEasing": "swing",
			        "hideEasing": "linear",
			        "showMethod": "fadeIn",
			        "hideMethod": "fadeOut",
			        "tapToDismiss": false
			    });
				return false;
			}
		}
		
		function IsEmail(email) {
            const regex =
/^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            if (!regex.test(email)) {
                return false;
            }
            else {
                return true;
            }
        }
	</script>
</body>
</html>