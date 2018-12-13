import { Component, OnInit } from '@angular/core';
import {User} from '../model/user.model';
import {FormsModule, NgForm} from '@angular/forms';
import {UserService} from '../shared/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  user: User;
  emailPattern = '^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$';
  roles: any;
  constructor(private userService: UserService) {
    this.roles = [ {'value': 'admin',
      'selected': false} , {'value': 'user',
      'selected': true}];
  }
  ngOnInit() {
    this.resetForm();
  }
  resetForm(form?: NgForm) {
    if (form != null) {
      form.reset();
    }
    this.user = {
      userName: '',
      password: '',
      email: '',
      firstName: '',
      lastName: '',
      roleList: []
    };
  }
  OnSubmit(form: NgForm) {
    this.userService.registerUser(form.value, this.roles)
      .subscribe((data: any) => {
        // console.log(data);
        if (data.status === 'OK') {
          this.resetForm(form);
          alert('User registration successful');
        } else {
          alert(data.Errors[0]);
        }
      });
  }
  updateSelectedRoles(index) {
    this.roles[index].selected = !this.roles[index].selected;

  }
}
