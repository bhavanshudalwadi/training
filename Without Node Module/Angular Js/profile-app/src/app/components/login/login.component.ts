import { Component } from '@angular/core';
import {
  FormControl,
  FormGroupDirective,
  NgForm,
  Validators,
  FormsModule,
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  AbstractControl,
} from '@angular/forms';
import {ErrorStateMatcher, MAT_DATE_LOCALE} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {provideNativeDateAdapter} from '@angular/material/core';
import { ApiService } from '../../api.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatSelectModule,
    MatButtonModule,
    MatDatepickerModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginDetails = {
    email: "",
    password: ""
  }

  constructor(private apiService: ApiService, private router: Router) {}

  handleLogin() {
    this.apiService.loginUser(this.loginDetails).subscribe({
      next: (response: any) => {
        alert(response.message ?? "Message Undefined");
        if(response.token) {
          localStorage.setItem('profile_app_user', response.token);
          this.router.navigateByUrl("/");
        }
      },
      error: (e) => {
        alert("Login Failed");
        console.error(e);
      },
      complete: () => {}
    })
  }
}


