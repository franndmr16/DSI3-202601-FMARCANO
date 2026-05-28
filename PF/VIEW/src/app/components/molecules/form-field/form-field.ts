import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { InputTextComponent } from '../../atoms/input-text/input-text';

@Component({
  selector: 'app-form-field',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, InputTextComponent],
  templateUrl: './form-field.html',
  styleUrls: ['./form-field.css']
})
export class FormFieldComponent {
  @Input() label: string = '';
  @Input() type: string = 'text';
  @Input() placeholder: string = '';
  @Input() control!: FormControl;
  @Input() errorMessage: string = 'Campo requerido';

  get hasError(): boolean {
    return !!(this.control?.invalid && this.control?.touched);
  }
}