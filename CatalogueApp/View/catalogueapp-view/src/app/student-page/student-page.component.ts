import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentsService } from '../services/students/students.service';
import { GetStudentService } from '../services/students/get-student.service';
import { DeleteStudentService } from '../services/students/delete-student.service';
import { UpdateStudentService } from '../services/students/update-student.service';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-student-page',
  templateUrl: './student-page.component.html',
  styleUrls: ['./student-page.component.css']
})
export class StudentPageComponent implements OnInit{

  student:any;
  studentId: any;
  deleted=false;
  update=false;

  years: number[] = [1, 2, 3];
  semesters: number[] = [1,2];

  updateStudentForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    year: ['default', Validators.required],
    semester: ['default', Validators.required],
    email: ['', Validators.required]
  });
  
  constructor(private fb: FormBuilder, private route: ActivatedRoute, private router: Router, private _getStudentService: GetStudentService, private _deleteStudentService: DeleteStudentService, private _updateStudentService: UpdateStudentService) {}

  ngOnInit(){
    this.route.params.subscribe(
      params=>{
        this.studentId= +params['id'];
        const studentData={id: this.studentId}
        this._getStudentService.getStudent(studentData).subscribe(
          respone => {this.student=respone.data},
          error => {console.error(error)}
        )
      }
    )
  }

  deleteStudent(){
    const studentData ={id: this.studentId}
    this._deleteStudentService.deleteStudent(studentData).subscribe(
      response => {console.log("Student deleted succesfully", response),
      this.deleted=true;
      if(this.deleted){
        this.router.navigate(['students']);
      }
    },
      error=>{console.error("Error at deleting student", error)
    }
    )
  }

  setUpdate(){
    if(this.update){
      this.update=false;
    }
    else{
      this.update=true;
    }
  }

  updateStudent(){
    const id = this.studentId
    const valueForm = this.updateStudentForm.value
    const studentValue = { ...valueForm, id}
    this._updateStudentService.putStudent(studentValue).subscribe(
      respone=>{console.log("Student updated succesfully", respone)
      this.router.navigate(['students']);
    }
    )
    }
}
