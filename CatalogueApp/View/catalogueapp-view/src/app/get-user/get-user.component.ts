import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { GetUserService } from '../services/users/get-user.service';

@Component({
  selector: 'app-get-user',
  templateUrl: './get-user.component.html',
  styleUrls: ['./get-user.component.css']
})
export class GetUserComponent {

  specificUser: any;
  message: any;

  getUserForm = this.fb.group({
    id: ['', Validators.required]
  })

  constructor(private fb: FormBuilder, private _getUserService: GetUserService){}

  onSubmit(){
    const userValue = this.getUserForm.value;
    this._getUserService.getUser(userValue).subscribe(
      respone=>{
        this.specificUser=respone.data;
        this.message=respone.message;
      }
    )
  }
}
