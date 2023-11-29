import { Component } from '@angular/core';
import { StudentsService } from '../services/students/students.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent {
  students:any[]=[];
  
  constructor(private _studentsService: StudentsService, private route: ActivatedRoute, private router: Router){}
  
  getStudents() {
    this._studentsService.getStudents().subscribe(
      data => {
        this.students = data;
      },
      error => {
        console.error('Error fetching students:', error);
      })
    }

    goToStudent(studentId: any) {
      this.router.navigate(['student-page', studentId]);
    }
}
