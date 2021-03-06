import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl = 'https://aht-nhan-su.herokuapp.com/rest/login/signin';
  constructor(private http: HttpClient) { }

  authenticate(username : string, password : string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get(`${this.baseUrl}`,{headers});
  }
}
