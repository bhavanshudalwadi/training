<?php
echo '<pre>'; // Preserve line breaks for better visualization

for ($row = 1; $row <= 8; $row++) {
    for ($col = 1; $col <= 8; $col++) {
        if (($row + $col) % 2 == 0) {
            echo "&#9633;"; // Use a white square symbol
        } else {
            echo "&#9632;"; // Use a black square symbol
        }
    }
    echo "<br>";
}

echo '</pre>'; // End of preserving line breaks
?>