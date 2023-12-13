import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GradesService {

  _url='http://localhost:5500/get/grades';
  _urlPost='http://localhost:5500/add/grade';

  constructor(private _http:HttpClient) { }

  
  getGrades(): Observable<any>{
    return this._http.get<any[]>(this._url);
  }

  postGrade(Id:any, gradeData:any): Observable<any>{
    const { subjectId, grade} = gradeData;
    const params = new HttpParams()
          .set('studentId', Id)
          .set('subjectId', subjectId)
          .set('grade', grade.toString());
    return this._http.post<any>(this._urlPost, null, { params });
  }
}
