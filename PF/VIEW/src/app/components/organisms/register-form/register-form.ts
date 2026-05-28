import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { 
  AbstractControl, 
  FormBuilder, 
  FormGroup, 
  ReactiveFormsModule, 
  ValidationErrors, 
  Validators, 
  FormControl 
} from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { FormFieldComponent } from '../../molecules/form-field/form-field';
import { FormRowComponent } from '../../molecules/form-row/form-row';
import { ButtonComponent } from '../../atoms/button/button';
import { AuthService } from '../../../auth/services/auth.service';

function passwordsMatch(group: AbstractControl): ValidationErrors | null {
  const pass = group.get('password')?.value;
  const confirm = group.get('confirmPassword')?.value;
  return pass === confirm ? null : { mismatch: true };
}

@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule, FormFieldComponent, FormRowComponent, ButtonComponent],
  templateUrl: './register-form.html',
  styleUrls: ['./register-form.css']
})
export class RegisterFormComponent {
  private auth = inject(AuthService);
  private router = inject(Router);
  
  form: FormGroup;
  loading = false;
  errorServer = '';

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      fullName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    }, { validators: passwordsMatch });
  }

  get fullNameCtrl()       { return this.form.get('fullName') as FormControl; }
  get emailCtrl()          { return this.form.get('email') as FormControl; }
  get passCtrl()           { return this.form.get('password') as FormControl; }
  get confirmPassCtrl()    { return this.form.get('confirmPassword') as FormControl; }
  
  get passwordMismatch()   {
    return this.form.errors?.['mismatch'] && this.confirmPassCtrl?.touched;
  }

  onSubmit() {
    if (this.form.invalid) { 
      this.form.markAllAsTouched(); 
      return; 
    }

    this.loading = true;
    this.errorServer = '';

    const formValue = this.form.value;
    
    const registerData = {
      nombre: formValue.fullName,    
      username: formValue.email,    
      password: formValue.password, 
      rol: 'USER'                   
    };

    this.auth.register(registerData).subscribe({
      next: () => {
        this.loading = false;
        alert('¡Usuario registrado con éxito!');
        this.router.navigate(['/login']);
      },
      error: (err: any) => {
        this.loading = false;
        this.errorServer = err.error?.message || 'Error al registrarse. Intenta nuevamente.';
        console.error('Error de registro:', err);
      }
    });
  }
}