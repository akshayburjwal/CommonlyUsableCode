import { Component, OnInit } from '@angular/core';
import {UserService} from '../shared/user.service';
import {Router} from '@angular/router';
import {LoginData} from '../model/login-data';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  submitForm(userName: string, password: string) {
    const loginData = new LoginData();
    loginData.userName = userName;
    loginData.password = password;
    this.userService.userAuthentication(loginData ).subscribe((data: any) =>  {
      localStorage.setItem('userToken', data.token);
      localStorage.setItem('roles', data.roles);
      this.router.navigate(['/Client']);
    } , error1 => {
    alert('Please check username and password');
    });
  }
}
