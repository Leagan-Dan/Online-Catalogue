import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentsService } from '../services/students/students.service';
import { GetStudentService } from '../services/students/get-student.service';
import { DeleteStudentService } from '../services/students/delete-student.service';
import { UpdateStudentService } from '../services/students/update-student.service';
import { FormBuilder, Validators } from '@angular/forms';
import { GradesService } from '../services/grades/grades.service';
import { AuthenticationServiceService } from '../services/authentication/authentication-service.service';

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
  grade=false;

  grades: any[] = [];
  years: number[] = [1, 2, 3];
  semesters: number[] = [1,2];

  updateStudentForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    year: ['default', Validators.required],
    semester: ['default', Validators.required],
    email: ['', Validators.required]
  });

  addGradeForm = this.fb.group({
    subjectId: ['', Validators.required],
    grade: ['', Validators.required]
  })
  
  constructor(private fb: FormBuilder, private route: ActivatedRoute, private router: Router, private _getStudentService: GetStudentService, private _deleteStudentService: DeleteStudentService, private _updateStudentService: UpdateStudentService, 
              private _gradesService: GradesService, private _authenticationSercice: AuthenticationServiceService) {}

  ngOnInit(){
    this.route.params.subscribe(
      params=>{
        this.studentId= +params['id'];
        const studentData={id: this.studentId}
        this._getStudentService.getStudent(studentData).subscribe(
          respone => {this.student=respone.data},
          error => {console.error(error)}
        )
        this.getStudentGrades(this.studentId);
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

  getStudentGrades(id: any){
    this._gradesService.getGrades().subscribe(
      data=>{
        this.grades = data.filter((grade: { student: { id: any; }; }) => grade.student.id === this.studentId);
      },
      error=>console.error(error)
    )
  }

  switchGrade(){
    if(this._authenticationSercice.isUserAdmin()){
    this.grade=true;
    }
  }

  addGrade(){
    this._gradesService.postGrade(this.studentId, this.addGradeForm.value).subscribe(
      response=> console.log(response),
      error=>console.error(error)
    )
  }

  
}
