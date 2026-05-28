import { Component } from '@angular/core';
import { RegisterFormComponent } from '../../../components/organisms/register-form/register-form';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RegisterFormComponent],
  templateUrl: './registro.html',
  styleUrl: './registro.css'
})
export class RegisterComponent {
}