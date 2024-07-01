<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="csrf-token" content="{{ csrf_token() }}" />
    @include('sub-views.tscript') 
    <title>Add/Update Student</title>
</head>
<body>
    @include('sub-views.navbar')
    <main class="container my-5">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <form id="{{isset($student)?"studentUpdateForm":"studentAddForm"}}">
                    {{-- @csrf --}}
                    @if(isset($student))
                        @method('PUT')
                        <input type="hidden" id="id" name="id" value="{{$student->id}}" />
                        <input type="hidden" id="oldImg" name="oldImg" value="{{$student->img}}" />
                    @endif
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="fname" class="form-label">First Name</label>
                                <input type="text" class="form-control" id="fname" name="fname" value="{{isset($student)?$student->fname:""}}"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="lname" class="form-label">Last Name</label>
                                <input type="text" class="form-control" id="lname" name="lname" value="{{isset($student)?$student->lname:""}}"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone</label>
                                <input type="tel" class="form-control" id="phone" name="phone" value="{{isset($student)?$student->phone:""}}"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" value="{{isset($student)?$student->email:""}}"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="img" class="form-label">Image</label>
                                <input type="file" class="form-control" id="img" name="img" accept="image/*" />
                            </div>
                        </div>
                        <div class="col-md-6 h-50">
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
    <script type="text/javascript">
        $.ajaxSetup({
            headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            }
        });
    </script>
    <script>
        $("#studentAddForm").on('submit', function(e) {
            e.preventDefault();
            
            $.ajax({
                url : "{{ url('/add-student') }}",
                type : "POST",
                data: new FormData(this),
                cache: false,
                contentType: false,
                processData: false,
                success : function(response) {
                    alert(response);
                    window.location.href = "{{ url('/') }}"
                },
                error : function(xhr, status, error) {
                    alert(xhr.responseText);
                    console.error(xhr.responseText);
                    console.error(error);
                }
            });
		});
    </script>
    <script>
        $("#studentUpdateForm").on('submit', function(e) {
            e.preventDefault();

            $.ajax({
                url: "{{ url('/update-student') }}",
                type: "POST",
                data: new FormData(this),
                cache: false,
                contentType: false,
                processData: false,
                success : function(response) {
                    alert(response);
                    window.location.href = "{{ url('/') }}"
                },
                error : function(xhr, status, error) {
                    alert(xhr.responseText);
                    console.error(xhr.responseText);
                    console.error(error);
                }
            });
		});
    </script>
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