import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GetStudentService {

  _url='http://localhost:5500/get/student';
  constructor(private _http:HttpClient) { }

  getStudent(studentData:any): Observable<any>{
    console.log("am intrat in service cu" + studentData);
    const { id } = studentData;
    const params = new HttpParams()
          .set('id', id);
    return this._http.get<any>(this._url, { params });
  }
}
