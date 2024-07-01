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
            <?= $this->Html->link(__('Edit Registration'), ['action' => 'edit', $registration->id], ['class' => 'side-nav-item']) ?>
            <?= $this->Form->postLink(__('Delete Registration'), ['action' => 'delete', $registration->id], ['confirm' => __('Are you sure you want to delete # {0}?', $registration->id), 'class' => 'side-nav-item']) ?>
            <?= $this->Html->link(__('List Registrations'), ['action' => 'index'], ['class' => 'side-nav-item']) ?>
            <?= $this->Html->link(__('New Registration'), ['action' => 'add'], ['class' => 'side-nav-item']) ?>
        </div>
    </aside>
    <div class="column-responsive column-80">
        <div class="registrations view content">
            <h3><?= h($registration->kmk_id) ?></h3>
            <table>
                <tr>
                    <th><?= __('Kmk Id') ?></th>
                    <td><?= h($registration->kmk_id) ?></td>
                </tr>
                <tr>
                    <th><?= __('Fname') ?></th>
                    <td><?= h($registration->fname) ?></td>
                </tr>
                <tr>
                    <th><?= __('Mname') ?></th>
                    <td><?= h($registration->mname) ?></td>
                </tr>
                <tr>
                    <th><?= __('Lname') ?></th>
                    <td><?= h($registration->lname) ?></td>
                </tr>
                <tr>
                    <th><?= __('Mobile') ?></th>
                    <td><?= h($registration->mobile) ?></td>
                </tr>
                <tr>
                    <th><?= __('Email') ?></th>
                    <td><?= h($registration->email) ?></td>
                </tr>
                <tr>
                    <th><?= __('Profile Img') ?></th>
                    <td><?= h($registration->profile_img) ?></td>
                </tr>
                <tr>
                    <th><?= __('G Fname') ?></th>
                    <td><?= h($registration->g_fname) ?></td>
                </tr>
                <tr>
                    <th><?= __('G Lname') ?></th>
                    <td><?= h($registration->g_lname) ?></td>
                </tr>
                <tr>
                    <th><?= __('G Mobile') ?></th>
                    <td><?= h($registration->g_mobile) ?></td>
                </tr>
                <tr>
                    <th><?= __('C Name') ?></th>
                    <td><?= h($registration->c_name) ?></td>
                </tr>
                <tr>
                    <th><?= __('C Mobile') ?></th>
                    <td><?= h($registration->c_mobile) ?></td>
                </tr>
                <tr>
                    <th><?= __('C Address') ?></th>
                    <td><?= h($registration->c_address) ?></td>
                </tr>
                <tr>
                    <th><?= __('Id') ?></th>
                    <td><?= $this->Number->format($registration->id) ?></td>
                </tr>
                <tr>
                    <th><?= __('Kmk Type') ?></th>
                    <td><?= $this->Number->format($registration->kmk_type) ?></td>
                </tr>
                <tr>
                    <th><?= __('Age Group') ?></th>
                    <td><?= $this->Number->format($registration->age_group) ?></td>
                </tr>
                <tr>
                    <th><?= __('Gender') ?></th>
                    <td><?= $this->Number->format($registration->gender) ?></td>
                </tr>
                <tr>
                    <th><?= __('Sport') ?></th>
                    <td><?= $this->Number->format($registration->sport) ?></td>
                </tr>
                <tr>
                    <th><?= __('Sub Sport') ?></th>
                    <td><?= $this->Number->format($registration->sub_sport) ?></td>
                </tr>
                <tr>
                    <th><?= __('Weight') ?></th>
                    <td><?= $registration->weight === null ? '' : $this->Number->format($registration->weight) ?></td>
                </tr>
                <tr>
                    <th><?= __('Height') ?></th>
                    <td><?= $registration->height === null ? '' : $this->Number->format($registration->height) ?></td>
                </tr>
                <tr>
                    <th><?= __('District') ?></th>
                    <td><?= $registration->district === null ? '' : $this->Number->format($registration->district) ?></td>
                </tr>
                <tr>
                    <th><?= __('Taluko') ?></th>
                    <td><?= $registration->taluko === null ? '' : $this->Number->format($registration->taluko) ?></td>
                </tr>
                <tr>
                    <th><?= __('Village') ?></th>
                    <td><?= $registration->village === null ? '' : $this->Number->format($registration->village) ?></td>
                </tr>
                <tr>
                    <th><?= __('Caste') ?></th>
                    <td><?= $this->Number->format($registration->caste) ?></td>
                </tr>
                <tr>
                    <th><?= __('Dob') ?></th>
                    <td><?= h($registration->dob) ?></td>
                </tr>
            </table>
        </div>
    </div>
</div>
