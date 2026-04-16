import { Component, inject, Input } from '@angular/core'; 
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; 
import { ButtonComponent } from '../../atoms/button/button'; 
import { LinkTextComponent } from '../../atoms/link-text/link-text';

@Component({
  selector: 'app-form-actions',
  standalone: true,
  imports: [CommonModule, ButtonComponent, LinkTextComponent], 
  template: `
    <div class="m-form-actions">
      <app-button [label]="buttonLabel" (click)="onAction()"></app-button>
      
      <app-link-text 
        [text]="isLogin ? '¿No tienes cuenta? Regístrate' : '¿Ya tienes cuenta? Inicia sesión'" 
        [link]="isLogin ? '/auth/register' : '/auth/login'">
      </app-link-text>
    </div>
  `,
  styles: [`
    .m-form-actions { display: flex; flex-direction: column; align-items: center; gap: 1rem; margin-top: 1.5rem; }
  `]
})
export class FormActionsComponent {
  // Los Inputs van DENTRO de la clase, pero ANTES de las funciones
  @Input() isLogin: boolean = false; 
  @Input() buttonLabel: string = 'Registrarse';

  private router = inject(Router);

  onAction() {
    this.router.navigate(['/coffee']); 
  }
}