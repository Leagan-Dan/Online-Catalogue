import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateStudentService {

  _url='http://localhost:5500/update/student';
  constructor(private _http:HttpClient) { }

  putStudent(studentData:any): Observable<any>{
    console.log("am intrat in service cu" + studentData);
    const { id, firstName, lastName, year, semester, email } = studentData;
    const params = new HttpParams()
          .set('id', id)
          .set('firstName', firstName)
          .set('lastName', lastName)
          .set('year', year.toString())
          .set('semester', semester.toString())
          .set('email', email);
    return this._http.put<any>(this._url, null, { params });
  }

}
