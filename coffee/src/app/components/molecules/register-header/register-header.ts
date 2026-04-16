import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-register-header',
  standalone: true,
  template: `
    <header class="m-register-header">
      <h1 class="a-title">{{ title }}</h1>
      <p class="a-subtitle">{{ subtitle }}</p>
    </header>
  `,
  styles: [`
    .m-register-header { text-align: center; margin-bottom: 20px; }
    .a-title { font-size: 24px; color: #333; margin-bottom: 8px; }
    .a-subtitle { color: #666; font-size: 14px; }
  `]
})
export class RegisterHeaderComponent {
  @Input() title: string = '';    // Esto permite recibir el texto
  @Input() subtitle: string = '';
}