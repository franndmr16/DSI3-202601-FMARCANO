import { Routes } from '@angular/router';
import { LoginPage } from './components/pages/login-page/login-page';
import { RegisterPage } from './components/pages/register-page/register-page';
import { CoffeePage } from './components/pages/coffee-page/coffee-page';

export const routes: Routes = [
  { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
  { path: 'auth/login', component: LoginPage },
  { path: 'auth/register', component: RegisterPage },
  { path: 'coffee', component: CoffeePage },
  { path: '**', redirectTo: 'auth/login' }
];