import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  private roles: string[];
  constructor(private router: Router, private userService: UserService) {}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (localStorage.getItem('userToken') != null) {
      this.roles = localStorage.getItem('roles').split(',');
      const necessaryRoles = next.data["roles"] as Array<string>;
      if (necessaryRoles) {
        const match = this.userService.matchRoles(necessaryRoles);
        if (match) {
          return true;
        } else {
              alert("no access to this operation");
          this.router.navigate(['/login']);
          return false;
        }
      }
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
}
