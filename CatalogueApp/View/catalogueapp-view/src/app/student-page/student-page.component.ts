import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentsService } from '../services/students/students.service';
import { GetStudentService } from '../services/students/get-student.service';
import { DeleteStudentService } from '../services/students/delete-student.service';

@Component({
  selector: 'app-student-page',
  templateUrl: './student-page.component.html',
  styleUrls: ['./student-page.component.css']
})
export class StudentPageComponent implements OnInit{

  student:any;
  studentId: any;
  deleted=false;

  constructor(private route: ActivatedRoute, private router: Router, private _getStudentService: GetStudentService, private _deleteStudentService: DeleteStudentService) {}

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
}
