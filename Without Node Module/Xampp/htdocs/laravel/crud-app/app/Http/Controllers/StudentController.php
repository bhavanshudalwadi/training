<?php

namespace App\Http\Controllers;

use App\Models\Student;
use Illuminate\Http\Request;

class StudentController extends Controller
{
    public function validateRequest(Request $req) {
        $req->validate([
            'fname' => 'required|string|max:255',
            'lname' => 'required|string|max:255',
            'phone' => 'required|string|max:20',
            'email' => 'required|email|max:255',
            'img' => 'required|image|mimes:jpeg,png,jpg|max:10240',
        ]);
    }
    public function index() {
        $students = Student::all();
        
        return view("students", compact("students"));
    }
    public function addStudent(Request $req) {
        $this->validateRequest($req);

        $imageName = "";
        if($req->hasFile('img')) {
            $imageName = rand(100,999)."-".$req->file('img')->getClientOriginalName();
            $req->file('img')->move(public_path('/uploads'), $imageName);
        }

        Student::create([
            "fname" => $req->fname,
            "lname" => $req->lname,
            "phone" => $req->phone,
            "email" => $req->email,
            "img" => $imageName,
        ]);

        return "Student Added Successful";
    }
    public function getStudent(Student $student) {
        return view("edit-student", compact("student"));
    }
    public function updateStudent(Request $req) {
        // $this->validateRequest($req);

        $updated = [
            "fname"=> $req->fname,
            "lname"=> $req->lname,
            "phone"=> $req->phone,
            "email"=> $req->email,
        ];

        // if($req->has("fname")) {
        //     $updated["fname"] = $req->fname;
        // }
        // if($req->has("lname")) {
        //     $updated["lname"] = $req->lname;
        // }
        // if($req->has("phone")) {
        //     $updated["phone"] = $req->phone;
        // }
        // if($req->has("email")) {
        //     $updated["email"] = $req->email;
        // }
        
        if($req->hasFile('img')) {
            $filePath = public_path('uploads\\').$req->oldImg;
            if(file_exists($filePath)) {
                unlink($filePath);
            }
            $imageName = rand(100,999)."-".$req->file('img')->getClientOriginalName();
            $req->file('img')->move(public_path('uploads'), $imageName);
            $updated["img"] = $imageName;
        }

        Student::find($req->id)->update($updated);

        return "Student Updated Successful";
    }
    public function deleteStudent(Student $student) {
        $student->delete();
        return redirect('/')->with('success','Student Deleted Successful');
    }
}
