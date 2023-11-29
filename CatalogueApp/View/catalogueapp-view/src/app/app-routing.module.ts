import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { AllFormsComponent } from './all-forms/all-forms.component';
import { StudentPageComponent } from './student-page/student-page.component';

const routes: Routes = [
  {path: '', redirectTo:"/students", pathMatch: 'full'},
  {path: 'all-forms', component: AllFormsComponent},
  {path: 'students', component: StudentsComponent},
  {path: 'student-page/:id', component: StudentPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
