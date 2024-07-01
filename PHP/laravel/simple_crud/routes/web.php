<?php

use App\Http\Controllers\StudentController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', [StudentController::class, 'index']);

Route::view('/add-student', 'edit-student');
Route::post('/add-student', [StudentController::class, 'addStudent']);

Route::get('/edit-student/{student}', [StudentController::class, 'getStudent']);
Route::put('/update-student', [StudentController::class, 'updateStudent']);

Route::delete('/delete-student/{student}', [StudentController::class, 'deleteStudent']);
