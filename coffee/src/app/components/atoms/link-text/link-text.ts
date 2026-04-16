import { Component, Input } from '@angular/core'; // Verifica que esté 'Input'
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-link-text',
  standalone: true,
  imports: [RouterModule],
  template: `
    <a [routerLink]="link" class="a-link-text">{{ text }}</a>
  `,
  styles: [`
    .a-link-text { color: #555; text-decoration: none; font-size: 14px; cursor: pointer; }
    .a-link-text:hover { text-decoration: underline; }
  `]
})
export class LinkTextComponent {
  // Estas dos líneas permiten que la molécula le pase información
  @Input() text: string = '';
  @Input() link: string = ''; 
}