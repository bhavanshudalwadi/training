import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';

// Single File Component
@Component({
  selector: 'app-header',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, RouterLink],
  template: `
    <mat-toolbar color="primary">
      <span class="me-2">Product Management</span>
      <button mat-icon-button routerLink="/">
        <mat-icon>home</mat-icon>
      </button>
      <button mat-icon-button routerLink="/products">
        <mat-icon>dns</mat-icon>
      </button>
    </mat-toolbar>
  `,
  styles: ``
})
export class HeaderComponent {

}
