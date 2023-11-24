import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostStudentService {

  _url='http://localhost:5500/add/student';
  constructor(private _http:HttpClient) { }

  postStudent(studentData:any): Observable<any>{
    console.log("am intrat in service cu" + studentData);
    const { firstName, lastName, year, semester, email } = studentData;
    const params = new HttpParams()
          .set('firstName', firstName)
          .set('lastName', lastName)
          .set('year', year.toString())
          .set('semester', semester.toString())
          .set('email', email);
    return this._http.post<any>(this._url, null, { params });
  }
}
