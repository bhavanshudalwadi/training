<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    @include('sub-views.tscript') 
    <title>{{isset($student)?"Update":"Add"}} Student Details</title>
</head>
<body>
    @include('sub-views.navbar')
    <main class="container my-5">
        @if(Session::has('success'))
            <p class="alert alert-success" >{{ Session::get('success') }}</p>
        @endif
        @if(Session::has('error'))
            <p class="alert alert-danger" >{{ Session::get('error') }}</p>
        @endif
        @if ($errors->any())
            <div class="alert alert-danger">
                <ul>
                    @foreach ($errors->all() as $error)
                        <li>{{ $error }}</li>
                    @endforeach
                </ul>
            </div>
        @endif
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <form action="{{isset($student)?url('/update-student'):url('/add-student')}}" method="POST" enctype="multipart/form-data">
                    @csrf
                    @if(isset($student))
                        @method('PUT')
                        <input type="hidden" id="id" name="id" value="{{$student->id}}" />
                        <input type="hidden" id="oldImg" name="oldImg" value="{{$student->img}}" />
                    @endif
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" value="{{isset($student)?$student->name:""}}"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" value="{{isset($student)?$student->email:""}}"/>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone</label>
                                <input type="tel" class="form-control" id="phone" name="phone" value="{{isset($student)?$student->phone:""}}"/>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="mb-3">
                                <label for="img" class="form-label">Image</label>
                                <input type="file" class="form-control" id="img" name="img" accept="image/*" />
                            </div>
                        </div>
                        <div class="col-md-4 h-50">
                            <div class="mb-3 text-center">
                                <img src="{{isset($student)?url('/uploads/'.$student->img):""}}" id="preview" style="width: 30%; height: auto; border-radius: 10px" alt="" />
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="mt-3 text-center">
                                <button type="submit" class="btn btn-primary">{{isset($student)?"Update":"Add"}} Student</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-2"></div>
        </div>
    </main>
    @include('sub-views.footer')
    @include('sub-views.bscript')
    <script>
        img.onchange = evt => {
            const [file] = img.files
            if (file) {
                preview.src = URL.createObjectURL(file)
            }
        }
    </script>
</body>
</html>