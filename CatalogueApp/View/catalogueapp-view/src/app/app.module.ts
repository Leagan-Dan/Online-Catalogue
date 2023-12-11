import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { DeleteStudentComponent } from './delete-student/delete-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { GetStudentComponent } from './get-student/get-student.component';
import { GetUserComponent } from './get-user/get-user.component';
import { PostUserComponent } from './post-user/post-user.component';
import { StudentsComponent } from './students/students.component';
import { AllFormsComponent } from './all-forms/all-forms.component';
import { StudentPageComponent } from './student-page/student-page.component';
import { AddSubjectComponent } from './add-subject/add-subject.component';
import { DeleteSubjectComponent } from './delete-subject/delete-subject.component';
import { UpdateSubjectComponent } from './update-subject/update-subject.component';
import { GetSubjectComponent } from './get-subject/get-subject.component';

@NgModule({
  declarations: [
    AppComponent,
    DeleteStudentComponent,
    UpdateStudentComponent,
    GetStudentComponent,
    GetUserComponent,
    PostUserComponent,
    StudentsComponent,
    AllFormsComponent,
    StudentPageComponent,
    AddSubjectComponent,
    DeleteSubjectComponent,
    UpdateSubjectComponent,
    GetSubjectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
