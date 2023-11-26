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

@NgModule({
  declarations: [
    AppComponent,
    DeleteStudentComponent,
    UpdateStudentComponent,
    GetStudentComponent,
    GetUserComponent
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
