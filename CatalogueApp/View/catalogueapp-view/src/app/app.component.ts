import { Component } from '@angular/core';
import { StudentsService } from './students.service';
import { FormBuilder, Validators } from '@angular/forms';
import { PostStudentService } from './post-student.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  students: any[] = [];
  years: number[] = [1, 2, 3];
  semesters: number[] = [1,2];

  addStudentForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    year: ['default', Validators.required],
    semester: ['default', Validators.required],
    email: ['',Validators.required]
  });


  constructor(private fb: FormBuilder, private _studentsService: StudentsService, private _poststudentService: PostStudentService){}

  getStudents() {
    this._studentsService.getStudents().subscribe(
      data => {
        this.students = data;
      },
      error => {
        console.error('Error fetching students:', error);
      })
    }

    onSubmit(){
      const studentValue=this.addStudentForm.value;
      this._poststudentService.postStudent(studentValue).subscribe(
        respone=>console.log("Student added succesfully", respone)
      )
    }
}
