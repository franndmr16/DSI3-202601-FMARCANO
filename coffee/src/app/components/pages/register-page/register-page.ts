import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterFormComponent } from '../../organisms/register-form/register-form';

@Component({
  selector: 'app-register-page',
  standalone: true,
  imports: [CommonModule, RegisterFormComponent],
  template: `
    <main class="p-register-page">
      <app-register-form></app-register-form>
    </main>
  `,
  styles: [`
    .p-register-page {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 100vw;
      height: 100vh;
      background-color: #ffffff; /* Blanco solo para Registro */
      position: fixed;
      top: 0;
      left: 0;
      z-index: 999;
    }
  `]
})
export class RegisterPage {}