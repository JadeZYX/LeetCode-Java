import java.util.HashSet;

public class P0142LinkedListCycle2 {
    public ListNode detectCycle(ListNode head){
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){//fast赶上了slow
                ListNode ptr=head;
                while(ptr!=fast){
                   ptr=ptr.next;
                   fast=fast.next;
                }
                return ptr;
            }
        }
        return null;//如果没有cycle，不是循环列表，则返回null
    }
    //推导过程 P1代表要找的节点，a代表从head到进环的距离，环里一圈是r，快慢指针相遇的点在P2，从进环的点到P2的距离是x,
    //所以环内剩余部分是r-x.
    //fast要走的路径是：fast=a+mr+x    slow=a+nr+x   所以a+mr+x=2(a+nr+x)-->a+x=mr-2nr
    //所以a+x也是环内r-x的距离。 所以当P1此时从head出发，fast指针从P2出发，当二者相遇当时候正好是入环节点
    public ListNode detectCycle1(ListNode head){
        HashSet<ListNode>set=new HashSet<>();
        ListNode cur=head;
        while(cur!=null){
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur=cur.next;
        }
        return null;
    }
    //用hashset的方法来做。时间和空间复杂度都是O(n),n为链表的长度。
    //但是题目要求O(1)的空间复杂度，所以要用更好的方法来做这道题目
    public ListNode detectCycle2(ListNode head) {
        //edge case
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
             fast = fast.next.next;
             slow = slow.next;
            if(fast == slow){//要先让快慢指针动起来，在看是否相遇，因为起点是同一位置
            //如果上来就写if语句，而非先动快慢指针，则在同一个位置上的快慢指针会直接跳出循环
              //遇到相遇点了,slow重置，此时快慢指针同速度
              slow = head;
              while(slow!=fast){
                  slow = slow.next;
                  fast = fast.next;
              }
              return slow;//当slow=fast时候，跳出上面的while循环且返回
              //如果根本就没有相遇的点，则if语句不满足，就不会进入到内层while
            }
        }
        return null;
    }
}
