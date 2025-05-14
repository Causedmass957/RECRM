import { Memo } from './memo.model';

export class MemoGroup {
  groupId?: number;
  groupName!: string;
  memos?: Memo[];             // List of memos in this group
}
