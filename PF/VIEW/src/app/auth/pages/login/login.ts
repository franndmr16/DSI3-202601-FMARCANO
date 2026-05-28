import { Component, inject } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginFormComponent } from '../../../components/organisms/login-form/login-form';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,LoginFormComponent ],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class LoginComponent {
  private auth = inject(AuthService);
  private router = inject(Router);
  email = '';
  password = '';

  onLogin() {
    this.auth.login({ email: this.email, password: this.password }).subscribe({
      next: () => this.router.navigate(['/pedidos']),
      error: (err) => alert('Error al iniciar sesión')
    });
  }
}