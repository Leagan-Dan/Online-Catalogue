import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostUserService {

  _url='http://localhost:5500/add/user'
  constructor(private _http:HttpClient) { }

  postStudent(userData:any): Observable<any>{
    const {username, password} = userData;
    const params = new HttpParams()
          .set('username', username)
          .set('password', password)
    return this._http.post<any>(this._url, null, {params});
  }
}
