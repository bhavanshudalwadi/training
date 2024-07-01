import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink],
  template: `
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container">
        <a class="navbar-brand" routerLink="/">Profile App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            @if(localStorage.getItem('profile_app_user') == null) {
              <li class="nav-item">
                <a class="nav-link" routerLink="/login" routerLinkActive="active">Login</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" routerLink="/register" routerLinkActive="active">Register</a>
              </li>
            }
            @else {
              <li class="nav-item">
                <a class="nav-link" routerLink="/" routerLinkActive="active">Home</a>
              </li>
              <li class="nav-item">
                <button class="btn btn-primary" (click)="logoutUser()">Logout</button>
              </li>
            }
          </ul>
        </div>
      </div>
    </nav>
  `,
  styles: ``
})
export class HeaderComponent {
  localStorage = localStorage;

  constructor(private router: Router) {}

  logoutUser() {
    this.localStorage.removeItem("profile_app_user")
    this.router.navigateByUrl("/login")
  }
}
