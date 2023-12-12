import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { GetUserService } from '../services/users/get-user.service';
import { Router } from '@angular/router';

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

  constructor(private fb: FormBuilder, private router:Router, private _getUserService: GetUserService){}

  onSubmit(){
    this._getUserService.getUsers().subscribe(
      response => {this.users=response;

      for(const user of this.users){
        if(user.username == this.loginForm.value.username && user.password == this.loginForm.value.password){
          console.log("Login success!");
          this.router.navigate(['/students']);
          break;
        }
      }
    }
    )
   
  }
}
