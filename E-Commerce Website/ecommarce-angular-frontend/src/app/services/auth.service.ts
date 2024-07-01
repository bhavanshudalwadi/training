import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loading = false
  authToken = localStorage.getItem('ecomm-angular-token')

  commonHeadersWithoutAuth = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  commonHeadersWithAuth = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Auth-Token': this.authToken ?? ''
    })
  }

  constructor(private httpClient: HttpClient, private router: Router) { }

  loginUser(loginDetails: any) {
    this.loading = true
    this.httpClient.post(
      `${environment.apiBaseURL}/users/login`,
      loginDetails,
      this.commonHeadersWithoutAuth
    ).subscribe({
      next: (response: any) => {
        this.loading = false
        if(response.authToken) {
          this.authToken = response.authToken
          localStorage.setItem('ecomm-angular-token', response.authToken);
          this.router.navigateByUrl("/");
        }
      },
      error: (e) => {
        this.loading = false
        alert("Login Failed");
        console.error(e);
      }
    })
  }

  registerUser(signUpDetails: any) {
    this.loading = true
    this.httpClient.post(
      `${environment.apiBaseURL}/users/signup`,
      signUpDetails,
      this.commonHeadersWithoutAuth
    ).subscribe({
      next: (response: any) => {
        this.loading = false
        if(response.authToken) {
          this.router.navigateByUrl("/login");
        }else {
          alert('Signup Failed')
          console.log(response)
        }
      },
      error: (e) => {
        this.loading = false
        alert("Signup Failed");
        console.error(e);
      },
      complete: () => {}
    })
  }

  logoutUser() {
    localStorage.removeItem('ecomm-angular-token')
    this.authToken = null
    this.router.navigateByUrl("/login");
  }
}
