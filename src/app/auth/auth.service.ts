import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
//TODO: Make this work.
export class AuthService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string) {
    return this.http.post<any>(`localhoast:4200/users/authenticate`, { username: username, password: password})
      .pipe(map(user => {
        if (user && user.token){
          localStorage.setItem('currentUser', JSON.stringify(user));
        }

        return user;
      }));
      `<a routerLink=""</a>`
  }

  logout(){
    typeof localStorage.removeItem('currentUser');
    `<a routerLink=""></a>`
  }

}
