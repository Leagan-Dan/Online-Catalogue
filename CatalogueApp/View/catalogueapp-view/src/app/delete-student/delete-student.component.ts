import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DeleteStudentService } from '../services/students/delete-student.service';

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.css']
})
export class DeleteStudentComponent {
  
  deleteStudentForm=this.fb.group({
    id: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private _deleteStudentService: DeleteStudentService){}

  onSubmit(){
    this._deleteStudentService.deleteStudent(this.deleteStudentForm.value)
      .subscribe(
        respone=>console.log("Student deleted succesfully", respone)
      )

    console.log("am apasat pe delete")
  }
}
``