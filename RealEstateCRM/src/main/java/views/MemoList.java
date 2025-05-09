package views;

import com.example.model.Memo;
import com.example.model.MemoGroup;

public class MemoList {
	private Memo memo;
    private MemoGroup group;

    public MemoList(Memo memo) {
        this.memo = memo;
    }

    public MemoList(MemoGroup group) {
        this.group = group;
    }

    public boolean isMemo() {
        return memo != null;
    }

    public boolean isGroup() {
        return group != null;
    }

    public Memo getMemo() {
        return memo;
    }

    public MemoGroup getGroup() {
        return group;
    }

    @Override
    public String toString() {
        if (memo != null) {
            return memo.getMemoTitle(); // or something richer
        } else if (group != null) {
            return "[Group] " + group.getGroupName(); // visually distinguish groups
        }
        return "";
    }

}
