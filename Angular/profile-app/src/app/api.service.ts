import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  // baseURL = "https://bhavanshu.000webhostapp.com/profile-app-backend/api";
  baseURL = "http://localhost/profile-app-backend/api";
  
  constructor(private httpClient: HttpClient) { }

  loginUser(loginDetails: any) {
    return this.httpClient.post(`${this.baseURL}/login`, loginDetails, { headers: { 'Accept': 'application/json' } });
  }

  registerUser(regDetails: any) {
    return this.httpClient.post(`${this.baseURL}/register`, regDetails, { headers: { 'Accept': 'application/json' } });
  }

  getProfileInfo(token: string) {
    return this.httpClient.get(`${this.baseURL}/profile`, { headers: { 'Accept': 'application/json', 'Authorization': `Bearer ${token}` } });
  }
}
