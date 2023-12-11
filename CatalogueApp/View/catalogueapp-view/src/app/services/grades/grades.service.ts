import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GradesService {

  _url='http://localhost:5500/get/grades';
  constructor(private _http:HttpClient) { }

  
  getGrades(): Observable<any>{
    return this._http.get<any[]>(this._url);
  }
}
