import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UpdateStudentService } from '../services/students/update-student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent {

  years: number[] = [1, 2, 3];
  semesters: number[] = [1,2];

  updateStudentForm = this.fb.group({
    id: ['', Validators.required],
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    year: ['default', Validators.required],
    semester: ['default', Validators.required],
    email: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private _updateStudentService: UpdateStudentService){}

  onSubmit(){
    const studentValue=this.updateStudentForm.value;
    this._updateStudentService.putStudent(studentValue).subscribe(
      respone=>console.log("Student updated succesfully", respone)
    )
  }
}
