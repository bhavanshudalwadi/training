<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Tymon\JWTAuth\Facades\JWTAuth;

class ApiController extends Controller
{
    // Register API (POST, formData)
    public function register(Request $req) {
        // Validate Registration Details
        $req->validate([
            "fname" => "required",
            "lname" => "required",
            "email" => "required|email|unique:users",
            "password" => "required",
            "dob" => "required",
            "gender" => "required",
            "address" => "required"
        ]);

        // Save Registration Details
        User::create([
            "fname" => $req->fname,
            "lname" => $req->lname,
            "email" => $req->email,
            "password" => Hash::make($req->password),
            "dob" => $req->dob,
            "gender" => $req->gender,
            "address" => $req->address
        ]);

        // Send Response
        return response()->json([
            "success" => true,
            "message" => "User Registration Successful",
            "errors" => null,
        ]);
    }

    // Login API (POST, formData)
    public function login(Request $req) {
        // Validating Login Details
        $req->validate([
            "email" => "required|email",
            "password" => "required"
        ]);

        // JWTAuth and generate token
        $token = JWTAuth::attempt(['email' => $req->email, 'password' => $req->password]);

        if(!empty($token)) {
            // Send Success Response
            return response()->json([
                "success" => true,
                "message" => "User Login Successful",
                "token" => $token,
                "errors" => null,
            ]);
        }

        // Send Failed Response
        return response()->json([
            "success" => false,
            "message" => "User Login Failed",
            "token" => $token,
            "errors" => "Invalid Login Details",
        ], 400);
    }

    // Profile API (GET)
    public function profile() {
        // Auth User and Get User Details
        $user = auth()->user();

        if(!empty($user)) {
            // Send Success Response
            return response()->json([
                "success" => true,
                "message" => "User Details",
                "user_details" => $user,
                "errors" => null,
            ]);
        }
        
        // Send Failed Response
        return response()->json([
            "success" => false,
            "message" => "Failed To Getting User Details",
            "user_details" => null,
            "errors" => "Unauthorized User",
        ], 401);
    }

    // Refresh Token (GET)
    public function refreshToken() {
        // Auth User and Generate New Token
        $newToken = auth()->refresh();

        if(!empty($newToken)) {
            // Send Success Response
            return response()->json([
                "success" => true,
                "message" => "New Access Token",
                "token" => $newToken,
                "errors" => null,
            ]);
        }

        // Send Failed Response
        return response()->json([
            "success" => false,
            "message" => "Failed To Generate New Access Token",
            "token" => null,
            "errors" => "Unauthorized User",
        ], 401);
    }

    // Logout API (GET)
    public function logout() {
        // Logout User
        auth()->logout();

        // Sending Response
        return response()->json([
            "success" => true,
            "message" => "User Logout Successful",
            "errors" => null,
        ]);
    }
}
