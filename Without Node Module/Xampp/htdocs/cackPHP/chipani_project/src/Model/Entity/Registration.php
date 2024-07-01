<?php
declare(strict_types=1);

namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Registration Entity
 *
 * @property int $id
 * @property string $kmk_id
 * @property int $kmk_type
 * @property string $fname
 * @property string $mname
 * @property string $lname
 * @property int $age_group
 * @property int $gender
 * @property \Cake\I18n\FrozenDate $dob
 * @property int $sport
 * @property int $sub_sport
 * @property string $mobile
 * @property string $email
 * @property string $password
 * @property string $profile_img
 * @property string|null $weight
 * @property string|null $height
 * @property int|null $district
 * @property int|null $taluko
 * @property int|null $village
 * @property int $caste
 * @property string|null $g_fname
 * @property string|null $g_lname
 * @property string|null $g_mobile
 * @property string|null $c_name
 * @property string|null $c_mobile
 * @property string|null $c_address
 */
class Registration extends Entity
{
    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * Note that when '*' is set to true, this allows all unspecified fields to
     * be mass assigned. For security purposes, it is advised to set '*' to false
     * (or remove it), and explicitly make individual fields accessible as needed.
     *
     * @var array<string, bool>
     */
    protected $_accessible = [
        'kmk_id' => true,
        'kmk_type' => true,
        'fname' => true,
        'mname' => true,
        'lname' => true,
        'age_group' => true,
        'gender' => true,
        'dob' => true,
        'sport' => true,
        'sub_sport' => true,
        'mobile' => true,
        'email' => true,
        'password' => true,
        'profile_img' => true,
        'weight' => true,
        'height' => true,
        'district' => true,
        'taluko' => true,
        'village' => true,
        'caste' => true,
        'g_fname' => true,
        'g_lname' => true,
        'g_mobile' => true,
        'c_name' => true,
        'c_mobile' => true,
        'c_address' => true,
        // '*'=> true,
    ];

    /**
     * Fields that are excluded from JSON versions of the entity.
     *
     * @var array<string>
     */
    protected $_hidden = [
        'password',
    ];
}
