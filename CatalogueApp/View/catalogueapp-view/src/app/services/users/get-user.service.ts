import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GetUserService {

  _url="http://localhost:5500/get/user"
  constructor(private _http:HttpClient) { }

  getUser(userData: any): Observable<any>{
    const params= new HttpParams()
            .set('id', userData.id);
    return this._http.get<any>(this._url, {params});
  }
}
