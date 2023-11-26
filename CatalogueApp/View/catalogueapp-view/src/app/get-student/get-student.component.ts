import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { GetStudentService } from '../services/students/get-student.service';

@Component({
  selector: 'app-get-student',
  templateUrl: './get-student.component.html',
  styleUrls: ['./get-student.component.css']
})
export class GetStudentComponent {

  specificStudent: any;
  message: any;

  getStudentForm=this.fb.group({
    id: ['', Validators.required]
  })

  constructor(private fb: FormBuilder, private _getStudentService: GetStudentService){}

 onSubmit() {
  const studentValue = this.getStudentForm.value;
  console.log(studentValue);

  this._getStudentService.getStudent(studentValue).subscribe(
    response => {
      this.specificStudent = response.data;
      this.message = response.message;
      console.log(this.specificStudent); // Move it here
    },
    error => {
      console.error(error); // Handle errors here if needed
    }
  );
}
}
