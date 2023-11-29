import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable
 } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DeleteStudentService {

  _url='http://localhost:5500/delete/student';
  constructor(private _http:HttpClient) { }

  
  deleteStudent(studentId:any): Observable<any>{
    console.log("am intrat in service cu" + studentId);
    const { id} = studentId;
    const params = new HttpParams()
          .set('id', id)  

    return this._http.delete(this._url, { params, responseType: 'text' });
  }
}

