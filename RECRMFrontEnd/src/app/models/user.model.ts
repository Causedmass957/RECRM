export class User {
    userId?: number;         // Optional if auto-generated
    username!: string;
    email!: string;
    password?: string;       // Optional for security, only sent on register/login
    role?: string;           // e.g., 'USER' or 'ADMIN'
  }
  