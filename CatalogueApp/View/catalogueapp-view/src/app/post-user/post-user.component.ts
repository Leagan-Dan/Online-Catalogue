import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PostUserService } from '../services/users/post-user.service';

@Component({
  selector: 'app-post-user',
  templateUrl: './post-user.component.html',
  styleUrls: ['./post-user.component.css']
})
export class PostUserComponent {

  addUserForm=this.fb.group({
    username: ['',Validators.required],
    password: ['',Validators.required]
  })

  constructor(private fb: FormBuilder, private _postUserService: PostUserService){}

  onSubmit(){
    this._postUserService.postStudent(this.addUserForm.value).subscribe(
      respone=>console.log("User added succesfully", respone)
    )
  }
}
