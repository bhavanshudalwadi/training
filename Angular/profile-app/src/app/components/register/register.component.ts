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
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'en-In'},
    provideNativeDateAdapter()
  ],
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
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  regInfo: RegDetails = {
    fname: "",
    lname: "",
    email: "",
    password: "",
    phone: "",
    dob: new Date(),
    gender: "",
    pincode: "",
    country: "",
    state: "",
    district: "",
    address: ""
  }

  constructor(private apiService: ApiService, private router: Router) {}

  registerUser() {
    const dateOfBirth = this.regInfo.dob.getFullYear() + "/" + (this.regInfo.dob.getMonth()+1) + "/" + this.regInfo.dob.getDate();
    
    this.apiService.registerUser({...this.regInfo, dob: dateOfBirth }).subscribe({
      next: (response: any) => {
        alert(response.message ?? "Message Undefined");
        if(response.message == "User Registration Successful") {
          this.router.navigateByUrl("/login");
        }else {
          alert(response.message);
        }
      },
      error: (e) => {
        alert("Registration Failed");
        console.error(e);
      },
      complete: () => {}
    })
  }
}

export type RegDetails = {
  fname: string,
  lname: string,
  email: string,
  password: string,
  phone: string | number,
  dob: Date,
  gender: string,
  pincode: string | number,
  country: string,
  state: string,
  district: string,
  address: string
} 
