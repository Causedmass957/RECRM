import { User } from './user.model';

export class Memo {
  memoId?: number;
  memoTitle!: string;
  memoContent!: string;
  user?: User;               // Optional reference to owner
}
