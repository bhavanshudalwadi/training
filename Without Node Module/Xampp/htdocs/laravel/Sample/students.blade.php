<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    @include('sub-views.tscript') 
    <title>Student List</title>
</head>
<body>
    @include('sub-views.navbar')
    <main class="container my-5">
        @if(Session::has('success'))
            <p class="alert alert-success" >{{ Session::get('success') }}</p>
        @endif
        <div class="row">
            <div class="col-6">
                <h2>Student List</h2>
            </div>
            <div class="col-6 text-end">
                <a href="{{url('/add-student')}}" class="btn btn-primary">Add Student</a>
            </div>
        </div>
        <table class="table table-striped table-hover mt-3">
            <thead class="table-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Image</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
                @foreach ($students as $student)
                    <tr>
                        <th class="align-middle" scope="row">{{$student->id}}</th>
                        {{-- <td><img src="{{url('storage/'.$student->img)}}" id="preview" style="width: 100px; height: auto; border-radius: 10px" alt="" /></td> --}}
                        <td valign="center"><img src="{{url('/uploads/'.$student->img)}}" id="preview" style="width: auto; height: 80px; border-radius: 10px" alt="" /></td>
                        <td class="align-middle">{{$student->fname}}</td>
                        <td class="align-middle">{{$student->lname}}</td>
                        <td class="align-middle">{{$student->phone}}</td>
                        <td class="align-middle">{{$student->email}}</td>
                        <td class="align-middle">
                            <div class="d-flex">
                                <a href="{{route('edit-student', $student->id)}}" class="btn btn-outline-success me-2" style="width: 80px">Edit</a>
                                <form action="{{url('/delete-student/'.$student->id)}}" method="POST">
                                    @csrf
                                    @method("DELETE")
                                    <input type="submit" onclick="return deleteStudent('{{$student->fname}}')" class="btn btn-outline-danger" style="width: 80px" value="Delete"/>
                                </form>
                            </div>
                        </td>
                    </tr>
                @endforeach
                @if(count($students) < 1)
                    <tr class="text-center fw-bold">
                        <td colspan="7">No Students Found</td>
                    </tr>
                @endif
            </tbody>
          </table>
    </main>
    @include('sub-views.footer')
    @include('sub-views.bscript')
    <script>
        function deleteStudent(name) {
            if(confirm(`Are you sure want to delete student named \`${name}\``)) {
                return true;
            }else {
                return false;
            }
        }
    </script>
</body>
</html>