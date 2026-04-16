import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-button',
  standalone: true,
  template: `
    <button class="a-button">
      {{ label }}
    </button>
  `,
  styles: [`
    .a-button {
      /* Colores base obligatorios */
      background-color: #002D55 !important; 
      color: #ffffff !important;
      
      /* Estructura */
      border: none;
      padding: 12px 24px;
      border-radius: 8px;
      font-size: 16px;
      font-weight: bold;
      width: 100%;
      cursor: pointer;
      display: block;
      
      /* Reset de visibilidad */
      opacity: 1 !important;
      visibility: visible !important;
    }

    .a-button:hover {
      background-color: #001a33 !important;
      color: #ffffff !important;
    }
  `]
})
export class ButtonComponent {
  @Input() label: string = '';
}