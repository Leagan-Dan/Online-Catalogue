import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubjectsService {

  _urlGet='http://localhost:5500/get/subjects';
  _urlPost='http://localhost:5500/add/subject';
  _urlPut='http://localhost:5500/update/subject';
  _urlDelete='http://localhost:5500/delete/subject';

  constructor(private _http:HttpClient) { }

  getSubjects(): Observable<any>{
    return this._http.get(this._urlGet);
  }

  deleteSubject(subjectId:any): Observable<any>{
    const params = new HttpParams().set('id', subjectId)
    return this._http.delete(this._urlDelete, {params, responseType:'text'});
  }

  addSubject(subjectData: any): Observable<any>{
      const{name, credits} = subjectData;
      const params = new HttpParams()
        .set('name', name)
        .set('credits', credits.toString());
      return this._http.post<any>(this._urlPost, null, {params});
  }

  updateSubject(subjectData:any): Observable<any>{
    const {id, name, credits}= subjectData;
    const params = new HttpParams()
      .set('id', id)
      .set('name', name)
      .set('credits', credits.toString())
    return this._http.put(this._urlPut, null, {params, responseType:'text'});
  }
}
