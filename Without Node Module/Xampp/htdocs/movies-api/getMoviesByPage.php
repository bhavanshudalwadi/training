<?php
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Credentials: true');
    header('Access-Control-Max-Age: 86400');
    header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, PATCH, DELETE");
    header("Access-Control-Allow-Headers: x-access-token, Origin, X-Requested-With, Content-Type, Accept");
    header("Content-Type: application/json");

    function fetchMovies($page, $perPage) {
        $csvFileName = "imdb_top_1000.csv";
        $data = [];

        if (($handle = fopen($csvFileName, "r")) !== FALSE) {
            $columnNames = fgetcsv($handle);

            $offset = ($page - 1) * $perPage;
            $counter = 0;

            while (($row = fgetcsv($handle)) !== FALSE) {
                $counter++;
                if ($counter <= $offset) {
                    continue; // Skip rows until reaching the offset
                }

                $movie = array_combine($columnNames, $row);
                $data[] = $movie;

                if (count($data) >= $perPage) {
                    break; // Stop reading after reaching the desired page size
                }
            }

            fclose($handle);
        }

        return $data;
    }

    $page = isset($_GET["page"]) && is_numeric($_GET["page"]) && $_GET["page"] > 0 ? $_GET["page"] : 1;
    $perPage = isset($_GET["per_page"]) && is_numeric($_GET["per_page"]) && $_GET["per_page"] > 0 ? $_GET["per_page"] : 5;

    $movies = fetchMovies($page, $perPage);
    echo json_encode($movies);
?>