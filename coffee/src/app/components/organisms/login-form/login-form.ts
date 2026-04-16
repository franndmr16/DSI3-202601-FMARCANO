import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterHeaderComponent } from '../../molecules/register-header/register-header';
import { InputFieldAtomComponent } from '../../atoms/input-field/input-field';
import { FormActionsComponent } from '../../molecules/form-actions/form-actions';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [CommonModule, RegisterHeaderComponent, InputFieldAtomComponent, FormActionsComponent],
  template: `
    <section class="o-login-form">
      <app-register-header 
        title="Iniciar Sesión" 
        subtitle="Ingresa tus datos para entrar">
      </app-register-header>
      
      <div class="m-login-fields">
        <app-input-field label="Correo" placeholder="usuario@elbosque.edu.co"></app-input-field>
        <app-input-field label="Contraseña" type="password" placeholder="********"></app-input-field>
      </div>

      <app-form-actions [isLogin]="true" buttonLabel="Ingresar"></app-form-actions>
    </section>
  `,
  styles: [`
    .o-login-form {
      background-color: #f2f2f2;
      padding: 40px;
      border-radius: 15px;
      box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
      width: 380px;
      display: flex;
      flex-direction: column;
      text-align: center;
    }
    .m-login-fields {
      display: flex;
      flex-direction: column;
      gap: 1.2rem;
      margin: 20px 0;
    }
  `]
})
export class LoginFormComponent {}