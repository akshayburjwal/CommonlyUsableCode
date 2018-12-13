import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SignUpComponent} from './sign-up/sign-up.component';
import {SignInComponent} from './sign-in/sign-in.component';
import {ClientPortalComponent} from './Client/clientportal.component';
import {UserDetailComponent} from './user-detail/user-detail.component';
import {AuthGuardGuard} from './shared/auth-guard.guard';
import {OperationComponent} from './operation/operation.component';

const routes: Routes = [
  {
    path: 'Client', component: ClientPortalComponent, canActivate: [AuthGuardGuard]
  },
  {path: 'operation', component: OperationComponent, data: {roles: ['admin']}},
  {
    path: 'signup', component: UserDetailComponent,
    children: [{path: '', component: SignUpComponent}]
  },
  {
    path: 'login', component: UserDetailComponent,
    children: [{path: '', component: SignInComponent}]
  },
  {
    path: '', redirectTo: 'login', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
