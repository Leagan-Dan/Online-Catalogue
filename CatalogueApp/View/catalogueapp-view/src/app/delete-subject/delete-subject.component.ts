import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { SubjectsService } from '../services/subject/subjects.service';

@Component({
  selector: 'app-delete-subject',
  templateUrl: './delete-subject.component.html',
  styleUrls: ['./delete-subject.component.css']
})
export class DeleteSubjectComponent {

  deleteSubjectForm=this.fb.group({
    id: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private _subjectService: SubjectsService) {}

  onSubmit(){
    this._subjectService.deleteSubject(this.deleteSubjectForm.value.id)
    .subscribe(
      response=>console.log("Subject deleted succesfully", response)
    )
  }
}
