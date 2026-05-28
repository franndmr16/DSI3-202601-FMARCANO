import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './button.html',
  styleUrls: ['./button.css']
})
export class ButtonComponent {
  @Input() label: string = 'Aceptar';
  @Input() type: 'button' | 'submit' = 'button';
  @Input() loading: boolean = false;
  @Input() disabled: boolean = false;
  @Input() variant: 'primary' | 'ghost' = 'primary';
}