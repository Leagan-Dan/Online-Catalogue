import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  private isAuthenticated: boolean = false;
  private isAdmin: boolean = false;

  login(){
    this.isAuthenticated=true;
  }

  logout(){
    this.isAuthenticated=false;
    this.isAdmin=false;
  }

  loginAdmin(){
    this.isAuthenticated=true;
    this.isAdmin=true;
  }

  isLoggedIn(){
    return this.isAuthenticated;
  }

  isUserAdmin(){
    return this.isAdmin;
  }
}
