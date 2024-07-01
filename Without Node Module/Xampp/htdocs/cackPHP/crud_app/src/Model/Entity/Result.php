<?php
declare(strict_types=1);

namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Result Entity
 *
 * @property int $id
 * @property int $student_id
 * @property int $maths
 * @property int $english
 * @property int $science
 * @property \Cake\I18n\FrozenTime $timestamp
 *
 * @property \App\Model\Entity\Student $student
 */
class Result extends Entity
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
        'student_id' => true,
        'maths' => true,
        'english' => true,
        'science' => true,
        'timestamp' => true,
        'student' => true,
    ];
}
