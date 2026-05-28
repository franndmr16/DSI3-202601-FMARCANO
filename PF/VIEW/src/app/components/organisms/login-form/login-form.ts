import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators, FormControl } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { FormFieldComponent } from '../../molecules/form-field/form-field';
import { ButtonComponent } from '../../atoms/button/button';
import { AuthService } from '../../../auth/services/auth.service';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule, FormFieldComponent, ButtonComponent],
  templateUrl: './login-form.html',
  styleUrls: ['./login-form.css']
})
export class LoginFormComponent {
  private auth = inject(AuthService);
  private router = inject(Router);
  
  form: FormGroup;
  loading = false;
  errorServer = '';

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  get emailCtrl() { return this.form.get('email') as FormControl; }
  get passCtrl()  { return this.form.get('password') as FormControl; }

  onSubmit() {
    if (this.form.invalid) { 
      this.form.markAllAsTouched(); 
      return; 
    }

    this.loading = true;
    this.errorServer = '';

    const loginData = {
      correo: this.form.value.email,
      password: this.form.value.password
    };

    this.auth.login(loginData).subscribe({
      next: () => {
        this.loading = false;
        this.router.navigate(['/dashboard']); 
      },
      error: (err) => {
        this.loading = false;
        this.errorServer = 'Credenciales incorrectas';
        console.error('Error:', err);
      }
    });
  }
}