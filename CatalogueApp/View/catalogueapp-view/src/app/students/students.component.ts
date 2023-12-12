import { Component } from '@angular/core';
import { StudentsService } from '../services/students/students.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent {
  students: any[] = [];
  filteredStudents: any[] = [];
  searchTerm: string = '';

  constructor(private _studentsService: StudentsService, private route: ActivatedRoute, private router: Router) {}

  getStudents() {
    this._studentsService.getStudents().subscribe(
      data => {
        this.students = data;
        this.filterStudents(); // Apply initial filtering
      },
      error => {
        console.error('Error fetching students:', error);
      });
  }

  filterStudents() {
    // Filter students based on the search term
    this.filteredStudents = this.students.filter((student) =>
      `${student.firstName} ${student.lastName}`.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
  }

  goToStudent(studentId: any) {
    this.router.navigate(['student-page', studentId]);
  }
}