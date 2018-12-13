import { Component, OnInit } from '@angular/core';
import {UserService} from '../shared/user.service';
import {Router} from '@angular/router';
import {User} from '../model/user.model';

@Component({
  selector: 'app-home',
  templateUrl: './clientportal.component.html',
  styleUrls: ['./clientportal.component.css']
})
export class ClientPortalComponent implements OnInit {
  clientList: User[];

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.userService.getClientData().subscribe((data: any) => {
      console.log(data);
      this.clientList = data;
    });
  }

  Logout() {
    localStorage.removeItem('userToken');
    this.router.navigate(['/login']);
  }

}
