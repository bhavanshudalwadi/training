<?php
declare(strict_types=1);

namespace App\Test\Fixture;

use Cake\TestSuite\Fixture\TestFixture;

/**
 * RegistrationsFixture
 */
class RegistrationsFixture extends TestFixture
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
                'kmk_id' => 'Lorem ip',
                'kmk_type' => 1,
                'fname' => 'Lorem ipsum dolor sit amet',
                'mname' => 'Lorem ipsum dolor sit amet',
                'lname' => 'Lorem ipsum dolor sit amet',
                'age_group' => 1,
                'gender' => 1,
                'dob' => '2024-03-14',
                'sport' => 1,
                'sub_sport' => 1,
                'mobile' => 'Lorem ipsum dolor ',
                'email' => 'Lorem ipsum dolor sit amet',
                'password' => 'Lorem ipsum dolor sit amet',
                'profile_img' => 'Lorem ipsum dolor sit amet',
                'weight' => 1.5,
                'height' => 1.5,
                'district' => 1,
                'taluko' => 1,
                'village' => 1,
                'caste' => 1,
                'g_fname' => 'Lorem ipsum dolor sit amet',
                'g_lname' => 'Lorem ipsum dolor sit amet',
                'g_mobile' => 'Lorem ipsum dolor ',
                'c_name' => 'Lorem ipsum dolor sit amet',
                'c_mobile' => 'Lorem ipsum dolor ',
                'c_address' => 'Lorem ipsum dolor sit amet',
            ],
        ];
        parent::init();
    }
}
