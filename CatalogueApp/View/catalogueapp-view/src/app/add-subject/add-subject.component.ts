import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { SubjectsService } from '../services/subject/subjects.service';

@Component({
  selector: 'app-add-subject',
  templateUrl: './add-subject.component.html',
  styleUrls: ['./add-subject.component.css']
})
export class AddSubjectComponent {

  credits: number[]= [4,5,6]
  
  addSubjectForm = this.fb.group({
    name: ['', Validators.required],
    credits: ['default', Validators.required]
  })

  constructor(private fb: FormBuilder, private _subjectsService: SubjectsService){}

  onSubmit(){
    const subjectValue=this.addSubjectForm.value;
    this._subjectsService.addSubject(subjectValue).subscribe(
      response=>console.log("Subject added succesfully", response)
    )
  }
}
