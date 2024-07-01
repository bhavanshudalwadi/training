<?php
declare(strict_types=1);

namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Registrations Model
 *
 * @method \App\Model\Entity\Registration newEmptyEntity()
 * @method \App\Model\Entity\Registration newEntity(array $data, array $options = [])
 * @method \App\Model\Entity\Registration[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Registration get($primaryKey, $options = [])
 * @method \App\Model\Entity\Registration findOrCreate($search, ?callable $callback = null, $options = [])
 * @method \App\Model\Entity\Registration patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Registration[] patchEntities(iterable $entities, array $data, array $options = [])
 * @method \App\Model\Entity\Registration|false save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Registration saveOrFail(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Registration[]|\Cake\Datasource\ResultSetInterface|false saveMany(iterable $entities, $options = [])
 * @method \App\Model\Entity\Registration[]|\Cake\Datasource\ResultSetInterface saveManyOrFail(iterable $entities, $options = [])
 * @method \App\Model\Entity\Registration[]|\Cake\Datasource\ResultSetInterface|false deleteMany(iterable $entities, $options = [])
 * @method \App\Model\Entity\Registration[]|\Cake\Datasource\ResultSetInterface deleteManyOrFail(iterable $entities, $options = [])
 */
class RegistrationsTable extends Table
{
    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config): void
    {
        parent::initialize($config);

        $this->setTable('registrations');
        $this->setDisplayField('id');
        $this->setPrimaryKey('id');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator): Validator
    {
        $validator
            ->scalar('kmk_id')
            ->maxLength('kmk_id', 10)
            ->requirePresence('kmk_id', 'create')
            ->notEmptyString('kmk_id')
            ->add('kmk_id', 'unique', ['rule' => 'validateUnique', 'provider' => 'table']);

        $validator
            ->integer('kmk_type')
            ->requirePresence('kmk_type', 'create')
            ->notEmptyString('kmk_type');

        $validator
            ->scalar('fname')
            ->maxLength('fname', 255)
            ->requirePresence('fname', 'create')
            ->notEmptyString('fname');

        $validator
            ->scalar('mname')
            ->maxLength('mname', 255)
            ->requirePresence('mname', 'create')
            ->notEmptyString('mname');

        $validator
            ->scalar('lname')
            ->maxLength('lname', 255)
            ->requirePresence('lname', 'create')
            ->notEmptyString('lname');

        $validator
            ->integer('age_group')
            ->requirePresence('age_group', 'create')
            ->notEmptyString('age_group');

        $validator
            ->integer('gender')
            ->requirePresence('gender', 'create')
            ->notEmptyString('gender');

        $validator
            ->date('dob')
            ->requirePresence('dob', 'create')
            ->notEmptyDate('dob');

        $validator
            ->integer('sport')
            ->requirePresence('sport', 'create')
            ->notEmptyString('sport');

        $validator
            ->integer('sub_sport')
            ->requirePresence('sub_sport', 'create')
            ->notEmptyString('sub_sport');

        $validator
            ->scalar('mobile')
            ->maxLength('mobile', 20)
            ->requirePresence('mobile', 'create')
            ->notEmptyString('mobile');

        $validator
            ->email('email')
            ->requirePresence('email', 'create')
            ->notEmptyString('email');

        $validator
            ->scalar('password')
            ->maxLength('password', 255)
            ->requirePresence('password', 'create')
            ->notEmptyString('password');

        $validator
            ->scalar('profile_img')
            ->maxLength('profile_img', 255)
            ->requirePresence('profile_img', 'create')
            ->notEmptyFile('profile_img');

        $validator
            ->decimal('weight')
            ->allowEmptyString('weight');

        $validator
            ->decimal('height')
            ->allowEmptyString('height');

        $validator
            ->integer('district')
            ->allowEmptyString('district');

        $validator
            ->integer('taluko')
            ->allowEmptyString('taluko');

        $validator
            ->integer('village')
            ->allowEmptyString('village');

        $validator
            ->integer('caste')
            ->requirePresence('caste', 'create')
            ->notEmptyString('caste');

        $validator
            ->scalar('g_fname')
            ->maxLength('g_fname', 255)
            ->allowEmptyString('g_fname');

        $validator
            ->scalar('g_lname')
            ->maxLength('g_lname', 255)
            ->allowEmptyString('g_lname');

        $validator
            ->scalar('g_mobile')
            ->maxLength('g_mobile', 20)
            ->allowEmptyString('g_mobile');

        $validator
            ->scalar('c_name')
            ->maxLength('c_name', 255)
            ->allowEmptyString('c_name');

        $validator
            ->scalar('c_mobile')
            ->maxLength('c_mobile', 20)
            ->allowEmptyString('c_mobile');

        $validator
            ->scalar('c_address')
            ->maxLength('c_address', 2000)
            ->allowEmptyString('c_address');

        return $validator;
    }

    /**
     * Returns a rules checker object that will be used for validating
     * application integrity.
     *
     * @param \Cake\ORM\RulesChecker $rules The rules object to be modified.
     * @return \Cake\ORM\RulesChecker
     */
    public function buildRules(RulesChecker $rules): RulesChecker
    {
        $rules->add($rules->isUnique(['kmk_id']), ['errorField' => 'kmk_id']);

        return $rules;
    }
}
