import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, fromEventPattern } from 'rxjs';
import { map } from 'rxjs/operators'
import { Post } from '../Post';
import { Post2 } from '../Post2';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient:HttpClient) { }

  login(username: string, password: string): Observable<Post[]> {
    //doGet with an option to fail to find a username
    return this.httpClient.get<Post[]>(placeholderForDAOLocation);
  }

  signup(username: string, password: string, firstName: string, lastName: string, email: string): Observable<Post2[]>{
    //doGet to check if the username is available and return that the username is taken and to choose another one
    //Doing the above causes the put to be unreachable - find some condition that gets returned?
    //This should work. \/
    this.login(username, password);
    //doPost or doPut to update the database
    return this.httpClient.post<Post2[]>(placeholderForDAOLocation, null);
  }
}
