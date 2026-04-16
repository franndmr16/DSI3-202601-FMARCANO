import { Injectable } from '@angular/core';
import { User } from '../models/user.models';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  saveUser(user: User) {
    localStorage.setItem('currentUser', JSON.stringify(user));
    console.log('Usuario guardado en el sistema:', user);
  }

  getUser() {
    const user = localStorage.getItem('currentUser');
    return user ? JSON.parse(user) : null;
  }
}