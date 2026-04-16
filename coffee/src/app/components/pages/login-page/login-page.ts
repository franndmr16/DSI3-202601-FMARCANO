import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from '../../organisms/login-form/login-form';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [CommonModule, LoginFormComponent],
  template: `
    <div class="p-login-page">
      <app-login-form></app-login-form>
    </div>
  `,
  styles: [`
    .p-login-page {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 100vw;
      height: 100vh;
      background-color: #ffffff; /* Fondo blanco total */
      position: fixed;
      top: 0;
      left: 0;
      z-index: 100;
      overflow: hidden;
    }
  `]
})
export class LoginPage {}