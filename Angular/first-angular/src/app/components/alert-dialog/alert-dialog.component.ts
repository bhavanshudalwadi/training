import { Component, Inject, Input } from '@angular/core';
import {
  MatDialogRef,
  MatDialogActions,
  MatDialogClose,
  MatDialogTitle,
  MatDialogContent,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';

export interface DialogData {
  title: string,
  message: string
}

@Component({
  selector: 'app-alert-dialog',
  standalone: true,
  imports: [MatButtonModule, MatDialogActions, MatDialogClose, MatDialogTitle, MatDialogContent],
  template: `
      <h2 mat-dialog-title>{{data.title}}</h2>
      <mat-dialog-content>
        {{data.message}}
      </mat-dialog-content>
      <mat-dialog-actions class="justify-content-end">
        <button mat-raised-button mat-dialog-close cdkFocusInitial color="primary">Ok</button>
      </mat-dialog-actions>
  `,
  styles: `
    .mdc-button {
      border-radius: 20px;
    }
    .mat-mdc-dialog-surface {
      border-radius: 20px;
      padding: 10px;
    }
  `
})
export class AlertDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<AlertDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ) {}
}
