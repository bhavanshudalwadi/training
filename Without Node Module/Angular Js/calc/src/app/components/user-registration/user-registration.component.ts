import { Component, ViewChild, inject } from '@angular/core';
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
import { ApiService } from '../../services/api.service';
import { ApiResponse } from '../../@types/globalTypes';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-user-registration',
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
  templateUrl: './user-registration.component.html',
  styles: `
    .w-100 {
      width: 100%;
    }
    .me-1 {
      margin-right: 1rem;
    }
  `,
})
export class UserRegistrationComponent {
  matcher!: MyErrorStateMatcher
  regForm!: FormGroup

  constructor(private fb: FormBuilder, private apiService: ApiService) { }

  ngOnInit() {
    this.regForm = this.fb.group({
      fname: ['', [Validators.required, Validators.minLength(3)]],
      lname: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email, Validators.minLength(6)]],
      phone: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      pincode: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(6)]],
      dob: ['', [Validators.required, Validators.minLength(6)]],
      gender: ['', [Validators.required]],
      country: ['', [Validators.required]],
      state: ['', [Validators.required]],
      district: ['', [Validators.required]],
      address: ['', [Validators.required]]
    });

    this.matcher = new MyErrorStateMatcher();
  }

  get control(): { [key: string]: AbstractControl } {
    return this.regForm.controls;
  }

  onPincodeChange(event: any) {
    let pincodeValue: number = event.target.value
    if(pincodeValue.toString().length == 6) {
      this.apiService.getPincodeDetails(pincodeValue).subscribe((result: ApiResponse) => {
        if(result[0].PostOffice != null && result[0].PostOffice.length > 0) {
          this.control['country'].setValue(result[0].PostOffice[0].Country ?? "");
          this.control['state'].setValue(result[0].PostOffice[0].State ?? ""); 
          this.control['district'].setValue(result[0].PostOffice[0].District ?? "");
        }else {
          this.control['pincode'].setErrors({ incorrect: true });
          this.control['country'].setValue("");
          this.control['state'].setValue(""); 
          this.control['district'].setValue("");
        }
      })
    }else {
      this.control['pincode'].setErrors({ incorrect: true });
      this.control['country'].setValue("");
      this.control['state'].setValue(""); 
      this.control['district'].setValue("");
    }
  }

  onSubmitForm() {
    console.log(this.regForm.value)
  }

  getString(json: any) {
    return JSON.stringify(json);
  }
}
