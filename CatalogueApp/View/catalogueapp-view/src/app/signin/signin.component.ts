import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { GetUserService } from '../services/users/get-user.service';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../services/authentication/authentication-service.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {

  users: any[]=[];

  loginForm=this.fb.group({
    username:['', Validators.required],
    password:['', Validators.required]
  })

  constructor(private fb: FormBuilder, private router:Router, private _getUserService: GetUserService, private _authenticationService: AuthenticationServiceService){}

  onSubmit(){
    this._getUserService.getUsers().subscribe(
      response => {this.users=response;

      for(const user of this.users){
        if(user.username == this.loginForm.value.username && user.password == this.loginForm.value.password){
          console.log("Login success!");
          if(user.username=="dan"){
            this._authenticationService.loginAdmin();
          }
          else{
          this._authenticationService.login();
          }
          this.router.navigate(['/students']);
          break;
        }
      }
    }
    )
   
  }
}
