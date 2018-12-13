import {Injectable, OnInit} from '@angular/core';
import {User} from '../model/user.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {LoginData} from '../model/login-data';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  readonly rootUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) { }
  registerUser(user: User, roles: any[]) {
    const body = new User();
    body.email = user.email;
    body.firstName = user.firstName;
    body.lastName = user.lastName;
    body.password = user.password;
    body.userName = user.userName;
    const roleList = new Array<string>();
    roles.forEach((data) => {
      if (data.selected) {
        roleList.push(data.value);
      }
    });
    body.roleList = roleList;
    console.log(body);
    console.log('body');
    // this.http.post(this.rootUrl + '/user/register', body);
    return this.http.post(this.rootUrl + '/user/register', body, { headers: {'No-Auth': 'True'}});
  }
  userAuthentication(loginData: LoginData) {
    return this.http.post(this.rootUrl + '/login', loginData, { headers: {'No-Auth': 'True'}});
  }
  getClientData() {
    return  this.http.get(this.rootUrl + '/client');
  }
  matchRoles(allowedRoles): boolean {
    let isMatch = false;
    const userRoles: string[] = localStorage.getItem('roles').split(',');
    allowedRoles.forEach(element => {
      if (userRoles.indexOf(element) > -1) {
        isMatch = true;
        return false;
      }
    });
    return isMatch;
  }
}
