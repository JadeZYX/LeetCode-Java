import java.util.HashSet;

public class P0141LinkedListCycle {
    public boolean hasCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null){
            //if hashset contains this node, then true
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
