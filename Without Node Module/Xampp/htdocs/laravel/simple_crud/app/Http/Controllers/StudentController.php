<?php

namespace App\Http\Controllers;

use App\Models\Student;
use Illuminate\Http\Request;

class StudentController extends Controller
{
    public function validateRequest(Request $req) {
        $req->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|email|max:255',
            'phone' => 'required|string|max:20',
            'img' => 'required|image|mimes:jpeg,png,jpg|max:10240',
        ]);
    }

    public function deleteFileIfExist($fileName) {
        $filePath = public_path('uploads\\').$fileName;
        if(file_exists($filePath)) {
            unlink($filePath);
        }
    }

    public function uploadFile($file) {
        $imageName = rand(100,999)."-".$file->getClientOriginalName();
        $file->move(public_path('uploads\\'), $imageName);
        return $imageName;
    }

    function index() {
        $students = Student::all();
        return view("students", compact("students"));
    }
    public function addStudent(Request $req) {
        $this->validateRequest($req);

        $imageName = "";
        if($req->hasFile('img')) {
            $imageName = $this->uploadFile($req->file('img'));
        }

        Student::create([
            "name" => $req->name,
            "email" => $req->email,
            "phone" => $req->phone,
            "img" => $imageName,
        ]);

        return redirect('/')->with("success","Student Added Successful");
    }
    public function getStudent(Student $student) {
        return view("edit-student", compact("student"));
    }
    public function updateStudent(Request $req) {
        $req->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|email|max:255',
            'phone' => 'required|string|max:20'
        ]);

        $updated = [
            "name"=> $req->name,
            "email"=> $req->email,
            "phone"=> $req->phone
        ];

        if($req->hasFile('img')) {
            $this->deleteFileIfExist($req->oldImg);
            $updated["img"] = $this->uploadFile($req->file('img'));
        }

        Student::find($req->id)->update($updated);
        return redirect('/')->with("success","Student Updated Successful");
    }
    public function deleteStudent(Student $student) {
        $this->deleteFileIfExist($student->img);
        $student->delete();
        return redirect('/')->with('success','Student Deleted Successful');
    }
}
