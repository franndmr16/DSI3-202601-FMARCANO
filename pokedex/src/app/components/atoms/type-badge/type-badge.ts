import { Component, Input } from '@angular/core'; 
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-type-badge',
  standalone: true,
  imports: [CommonModule],
  template: `
    <span [class]="'a-type-badge a-type-badge--' + type.toLowerCase()">
      {{ type | uppercase }}
    </span>
  `,
  styleUrls: ['./type-badge.css'] 
})
export class TypeBadgeComponent {
  @Input() type: string = '';
}