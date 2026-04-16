import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldAtomComponent } from '../../atoms/input-field/input-field';
import { SelectFieldComponent } from '../../atoms/select-field/select-field';

@Component({
  selector: 'app-personal-data-form',
  standalone: true,
  imports: [CommonModule, InputFieldAtomComponent, SelectFieldComponent],
  template: `
    <div class="m-personal-data-form">
      <div class="m-personal-data-form__row">
        <app-input-field label="Cédula" placeholder="1234567890"></app-input-field>
        <app-input-field label="Nombre" placeholder="Juan García"></app-input-field>
      </div>
      
      <app-input-field label="Correo electrónico" placeholder="usuario@elbosque.edu.co" type="email"></app-input-field>
      
      <app-select-field label="Carrera"></app-select-field>
    </div>
  `,
  styles: [`
    .m-personal-data-form {
      display: flex;
      flex-direction: column;
      gap: 1rem;
    }
    .m-personal-data-form__row {
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 1rem;
    }
  `]
})
export class PersonalDataForm { }