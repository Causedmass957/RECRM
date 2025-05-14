import { User } from './user.model';

export class Contact {
  contactId?: number;
  contactName!: string;
  contactEmail!: string;
  contactDOB!: string;       // ISO string (e.g., "1990-01-01")
  contactPhone!: string;
  user?: User;               // Optional reference to owner
}
