import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService] // 👈 OR provide it in app.config.ts globally
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onLogin(): void {
    if (!this.username || !this.password) {
      this.errorMessage = 'Username and password are required';
      return;
    }

    this.authService.login({ username: this.username, password: this.password })
      .subscribe({
        next: (token: string) => {
          this.authService.storeToken(token);
          this.router.navigate(['/home']);
        },
        error: () => {
          this.errorMessage = 'Invalid username or password';
        }
      });
  }
}
