import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { SubjectsService } from '../services/subject/subjects.service';

@Component({
  selector: 'app-update-subject',
  templateUrl: './update-subject.component.html',
  styleUrls: ['./update-subject.component.css']
})
export class UpdateSubjectComponent {

  credits: number[] = [4,5,6];

  updateSubjectForm=this.fb.group({
    id: ['', Validators.required],
    name: ['', Validators.required],
    credits: ['default', Validators.required]
})
  constructor(private fb: FormBuilder, private _subjectsService: SubjectsService){}

  onSubmit(){
    const subjectValue=this.updateSubjectForm.value;
    this._subjectsService.updateSubject(subjectValue).subscribe(
      response=>console.log("Subject updated succesfully", response),
      error=>console.error("Error at subject update", error)
    )
  }
}
