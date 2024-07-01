<?php
    include_once("common.php");
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>C Programs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="d-flex justify-content-center my-3">
        <div class="card">
            <div class="card-body">
                <select class="form-select" id="program">
                    <option value="">Select Program</option>
                    <?php
                        foreach ($cPrograms as $key => $value) {
                            echo "<option value='$key'>".($key+1).". $value</option>";
                        }
                    ?>
                </select>
                <div class="card mt-3">
                    <div class="card-body text-center" id="program-result">
                        Select Program To View Result
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    
    <script>
        $("#program").on('change', function() {
			let program = $(this).val();
			if(program != '') {
                program = parseInt(program) + 1;
				$.ajax({
					url : `./programs/${program}.php`,
					type : "GET",
					success : function(response) {
						$("#program-result").html(response);
					},
					error : function(xhr, status, error) {
						$("#program-result").html(xhr.responseText);
						console.error(xhr.responseText);
						console.error(error);
					}
				});
			}else {
                $("#program-result").html("Select Program To View Result");
            }
		})
    </script>
</body>
</html>