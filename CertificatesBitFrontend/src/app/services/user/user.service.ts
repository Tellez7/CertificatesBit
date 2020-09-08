import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/model/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  userExistsByData(user: string, password: string) {
    return this.http.get<User>(environment.urlUserExistsByData, {
      params: {
        'userEntry': user,
        'password': password
      }
    });
  }
}
