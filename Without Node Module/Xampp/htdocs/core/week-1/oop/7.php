<?php
    class DateConverter {
        public static function convertToDate($stringDate) {
            $date = DateTime::createFromFormat('m-d-Y', $stringDate);
            return $date->format('Y-m-d');
        }
    }

    echo DateConverter::convertToDate('12-08-2004');
?>