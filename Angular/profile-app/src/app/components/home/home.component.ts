import { Component } from '@angular/core';
import { ApiService } from '../../api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  token!: string | null
  profileInfo = {
    id: -1,
    fname: "",
    lname: "",
    email: "",
    phone: "",
    dob: "",
    gender: "",
    pincode: "",
    country: "",
    state: "",
    district: "",
    address: "",
    email_verified_at: "",
    created_at: "",
    updated_at: ""
  }

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit() {
    this.token = localStorage.getItem("profile_app_user");

    if(this.token != null) {
      this.apiService.getProfileInfo(this.token).subscribe({
        next: (response: any) => {
          if(response.user_details) {
            this.profileInfo = response.user_details
          }else {
            alert(response.message);
          }
        },
        error: (e) => {
          alert("Failed to get profile information");
          console.error(e);
        },
        complete: () => {}
      })
    }else {
      this.router.navigateByUrl("/login")
    }
  }
}
