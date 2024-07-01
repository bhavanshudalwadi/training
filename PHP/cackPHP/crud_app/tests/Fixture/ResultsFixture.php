<?php
declare(strict_types=1);

namespace App\Test\Fixture;

use Cake\TestSuite\Fixture\TestFixture;

/**
 * ResultsFixture
 */
class ResultsFixture extends TestFixture
{
    /**
     * Init method
     *
     * @return void
     */
    public function init(): void
    {
        $this->records = [
            [
                'id' => 1,
                'student_id' => 1,
                'maths' => 1,
                'english' => 1,
                'science' => 1,
                'timestamp' => '2024-03-28 09:12:20',
            ],
        ];
        parent::init();
    }
}
