import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  _url='http://localhost:5500/get/students';
  constructor(private _http:HttpClient) { }

  getStudents(): Observable<any[]>{
    console.log("am apelat service");
    console.log(this._http.get<any>(this._url));
    return this._http.get<any[]>(this._url);
  }
}
