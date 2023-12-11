import { Component, OnInit } from '@angular/core';
import { SubjectsService } from '../services/subject/subjects.service';

@Component({
  selector: 'app-get-subject',
  templateUrl: './get-subject.component.html',
  styleUrls: ['./get-subject.component.css']
})
export class GetSubjectComponent implements OnInit{

  subjects:any[] = [];

  constructor(private _subjectService: SubjectsService){}

  ngOnInit(): void {
    this.getSubjects();
  }
  
  getSubjects(){
    this._subjectService.getSubjects().subscribe(
      data=>{
        this.subjects = data;
      },
      error =>{
        console.log(error);
      }
    )
  }
}
