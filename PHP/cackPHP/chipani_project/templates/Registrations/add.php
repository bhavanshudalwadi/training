<?php
/**
 * @var \App\View\AppView $this
 * @var \Cake\Datasource\EntityInterface $registration
 */
?>
<div class="row">
    <aside class="column">
        <div class="side-nav">
            <h4 class="heading"><?= __('Actions') ?></h4>
            <?= $this->Html->link(__('List Registrations'), ['action' => 'index'], ['class' => 'side-nav-item']) ?>
        </div>
    </aside>
    <div class="column-responsive column-80">
        <div class="registrations form content">
            <?= $this->Form->create($registration) ?>
            <fieldset>
                <legend><?= __('Add Registration') ?></legend>
                <?php
                    echo $this->Form->control('kmk_id', ['type' => 'text', 'label' => 'Kmk Id']);
                    echo "<label for='gender'>Kmk Type</label>";
                    echo $this->Form->select('kmk_type', [0 => 'Type 1', 1 => 'Type 2'], ['empty' => true]);
                    echo $this->Form->control('fname');
                    echo $this->Form->control('mname');
                    echo $this->Form->control('lname');
                    echo "<label for='gender'>Age Group</label>";
                    echo $this->Form->select('age_group', [0 => ''], ['empty' => true]);
                    echo "<label for='gender'>Gender</label>";
                    echo $this->Form->radio('gender', [' Male', ' Female']);
                    echo "<label for='gender'>Date of Birth</label>";
                    echo $this->Form->date('dob', [
                        'min' => date('Y') - 70,
                        'max' => date('Y') - 18,
                    ]);
                    echo $this->Form->control('sport');
                    echo $this->Form->control('sub_sport');
                    echo $this->Form->control('mobile');
                    echo $this->Form->control('email');
                    echo $this->Form->control('password');
                    echo $this->Form->control('profile_img');
                    echo $this->Form->control('weight');
                    echo $this->Form->control('height');
                    echo $this->Form->control('district');
                    echo $this->Form->control('taluko');
                    echo $this->Form->control('village');
                    echo $this->Form->control('caste');
                    echo $this->Form->control('g_fname');
                    echo $this->Form->control('g_lname');
                    echo $this->Form->control('g_mobile');
                    echo $this->Form->control('c_name');
                    echo $this->Form->control('c_mobile');
                    echo $this->Form->control('c_address');
                ?>
            </fieldset>
            <?= $this->Form->button(__('Submit')) ?>
            <?= $this->Form->end() ?>
        </div>
    </div>
</div>
