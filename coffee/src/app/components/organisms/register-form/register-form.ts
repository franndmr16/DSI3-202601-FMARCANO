import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterHeaderComponent } from '../../molecules/register-header/register-header';
import { InputFieldAtomComponent } from '../../atoms/input-field/input-field';
import { FormActionsComponent } from '../../molecules/form-actions/form-actions';

@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [CommonModule, RegisterHeaderComponent, InputFieldAtomComponent, FormActionsComponent],
  template: `
    <section class="o-register-form">
      <app-register-header 
        title="Crear cuenta" 
        subtitle="Completa el formulario">
      </app-register-header>
      
      <div class="m-register-fields">
        <app-input-field label="Cédula" placeholder="123456789"></app-input-field>
        <app-input-field label="Nombre" placeholder="Juan García"></app-input-field>
        <app-input-field label="Correo" placeholder="usuario@elbosque.edu.co"></app-input-field>
        <app-input-field label="Carrera" placeholder="Ingeniería"></app-input-field>
      </div>

      <app-form-actions [isLogin]="false" buttonLabel="Registrarse"></app-form-actions>
    </section>
  `,
  styles: [`
    .o-register-form {
      background-color: #f2f2f2; /* Cuadro gris */
      padding: 40px;
      border-radius: 15px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 400px;
    }
    .m-register-fields {
      display: flex;
      flex-direction: column;
      gap: 1.2rem;
      margin-bottom: 25px;
    }
  `]
})
export class RegisterFormComponent {}