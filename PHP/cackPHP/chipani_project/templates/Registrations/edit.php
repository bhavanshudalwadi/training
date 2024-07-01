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
            <?= $this->Form->postLink(
                __('Delete'),
                ['action' => 'delete', $registration->id],
                ['confirm' => __('Are you sure you want to delete # {0}?', $registration->id), 'class' => 'side-nav-item']
            ) ?>
            <?= $this->Html->link(__('List Registrations'), ['action' => 'index'], ['class' => 'side-nav-item']) ?>
        </div>
    </aside>
    <div class="column-responsive column-80">
        <div class="registrations form content">
            <?= $this->Form->create($registration) ?>
            <fieldset>
                <legend><?= __('Edit Registration') ?></legend>
                <?php
                    echo $this->Form->control('kmk_id');
                    echo $this->Form->control('kmk_type');
                    echo $this->Form->control('fname');
                    echo $this->Form->control('mname');
                    echo $this->Form->control('lname');
                    echo $this->Form->control('age_group');
                    echo $this->Form->control('gender');
                    echo $this->Form->control('dob');
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
