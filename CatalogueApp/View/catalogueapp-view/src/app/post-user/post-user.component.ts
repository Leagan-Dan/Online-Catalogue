import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PostUserService } from '../services/users/post-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-user',
  templateUrl: './post-user.component.html',
  styleUrls: ['./post-user.component.css']
})
export class PostUserComponent {

  addUserForm=this.fb.group({
    username: ['',Validators.required],
    password: ['',Validators.required],
    confirmPassword: ['', Validators.required]
  })

  constructor(private fb: FormBuilder, private router: Router, private _postUserService: PostUserService){}

  onSubmit(){
    if(this.addUserForm.value.password != this.addUserForm.value.confirmPassword){
      console.error("Passwords dont match");
    }
    else{
    this._postUserService.postStudent(this.addUserForm.value).subscribe(
      respone=>{console.log("User added succesfully", respone),
      this.router.navigate(['/login']);}
    )
    }
  }
}
