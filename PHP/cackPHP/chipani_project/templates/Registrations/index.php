<?php
/**
 * @var \App\View\AppView $this
 * @var iterable<\Cake\Datasource\EntityInterface> $registrations
 */
?>
<div class="registrations index content">
    <?= $this->Html->link(__('New Registration'), ['action' => 'add'], ['class' => 'button float-right']) ?>
    <h3><?= __('Registrations') ?></h3>
    <div class="table-responsive">
        <table>
            <thead>
                <tr>
                    <th><?= $this->Paginator->sort('id') ?></th>
                    <th><?= $this->Paginator->sort('kmk_id') ?></th>
                    <!-- <th><?= $this->Paginator->sort('kmk_type') ?></th> -->
                    <th><?= $this->Paginator->sort('fname') ?></th>
                    <th><?= $this->Paginator->sort('mname') ?></th>
                    <th><?= $this->Paginator->sort('lname') ?></th>
                    <!-- <th><?= $this->Paginator->sort('age_group') ?></th> -->
                    <!-- <th><?= $this->Paginator->sort('gender') ?></th> -->
                    <th><?= $this->Paginator->sort('dob') ?></th>
                    <th><?= $this->Paginator->sort('sport') ?></th>
                    <th><?= $this->Paginator->sort('sub_sport') ?></th>
                    <th><?= $this->Paginator->sort('mobile') ?></th>
                    <th><?= $this->Paginator->sort('email') ?></th>
                    <!-- <th><?= $this->Paginator->sort('profile_img') ?></th> -->
                    <th><?= $this->Paginator->sort('weight') ?></th>
                    <th><?= $this->Paginator->sort('height') ?></th>
                    <th><?= $this->Paginator->sort('district') ?></th>
                    <!-- <th><?= $this->Paginator->sort('taluko') ?></th> -->
                    <!-- <th><?= $this->Paginator->sort('village') ?></th> -->
                    <!-- <th><?= $this->Paginator->sort('caste') ?></th> -->
                    <th><?= $this->Paginator->sort('g_fname') ?></th>
                    <!-- <th><?= $this->Paginator->sort('g_lname') ?></th> -->
                    <!-- <th><?= $this->Paginator->sort('g_mobile') ?></th> -->
                    <th><?= $this->Paginator->sort('c_name') ?></th>
                    <!-- <th><?= $this->Paginator->sort('c_mobile') ?></th> -->
                    <!-- <th><?= $this->Paginator->sort('c_address') ?></th> -->
                    <th class="actions"><?= __('Actions') ?></th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($registrations as $registration): ?>
                <tr>
                    <td><?= $this->Number->format($registration->id) ?></td>
                    <td><?= h($registration->kmk_id) ?></td>
                    <!-- <td><?= $this->Number->format($registration->kmk_type) ?></td> -->
                    <td><?= h($registration->fname) ?></td>
                    <td><?= h($registration->mname) ?></td>
                    <td><?= h($registration->lname) ?></td>
                    <!-- <td><?= $this->Number->format($registration->age_group) ?></td>
                    <td><?= $this->Number->format($registration->gender) ?></td> -->
                    <td><?= h($registration->dob) ?></td>
                    <td><?= $this->Number->format($registration->sport) ?></td>
                    <td><?= $this->Number->format($registration->sub_sport) ?></td>
                    <td><?= h($registration->mobile) ?></td>
                    <td><?= h($registration->email) ?></td>
                    <!-- <td><?= h($registration->profile_img) ?></td> -->
                    <td><?= $registration->weight === null ? '' : $this->Number->format($registration->weight) ?></td>
                    <td><?= $registration->height === null ? '' : $this->Number->format($registration->height) ?></td>
                    <td><?= $registration->district === null ? '' : $this->Number->format($registration->district) ?></td>
                    <!-- <td><?= $registration->taluko === null ? '' : $this->Number->format($registration->taluko) ?></td>
                    <td><?= $registration->village === null ? '' : $this->Number->format($registration->village) ?></td>
                    <td><?= $this->Number->format($registration->caste) ?></td> -->
                    <td><?= h($registration->g_fname) ?></td>
                    <!-- <td><?= h($registration->g_lname) ?></td>
                    <td><?= h($registration->g_mobile) ?></td> -->
                    <td><?= h($registration->c_name) ?></td>
                    <!-- <td><?= h($registration->c_mobile) ?></td>
                    <td><?= h($registration->c_address) ?></td> -->
                    <td class="actions">
                        <?= $this->Html->link(__('View'), ['action' => 'view', $registration->id]) ?>
                        <?= $this->Html->link(__('Edit'), ['action' => 'edit', $registration->id]) ?>
                        <?= $this->Form->postLink(__('Delete'), ['action' => 'delete', $registration->id], ['confirm' => __('Are you sure you want to delete # {0}?', $registration->id)]) ?>
                    </td>
                </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
    <div class="paginator">
        <ul class="pagination">
            <?= $this->Paginator->first('<< ' . __('first')) ?>
            <?= $this->Paginator->prev('< ' . __('previous')) ?>
            <?= $this->Paginator->numbers() ?>
            <?= $this->Paginator->next(__('next') . ' >') ?>
            <?= $this->Paginator->last(__('last') . ' >>') ?>
        </ul>
        <p><?= $this->Paginator->counter(__('Page {{page}} of {{pages}}, showing {{current}} record(s) out of {{count}} total')) ?></p>
    </div>
</div>
