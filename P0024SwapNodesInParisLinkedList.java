public class P0024SwapNodesInParisLinkedList {
    public ListNode swapPairs0(ListNode head){
        if(head==null)return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null&&cur.next.next!=null){
            ListNode next1 = cur.next;
            ListNode next2 = cur.next.next;
            ListNode next3 = cur.next.next.next;
            next2.next = next1;
            next1.next = next3;
            cur.next = next2;
            cur = next1;
        }
        return dummy.next;
    }
    public ListNode swapPairs(ListNode head){
        //base case
        if(head==null||head.next==null)return head;
        ListNode first=head,last=head.next;
          //how to connect the swap nodes between within whole linked list
           //like make 2->1 point to 4->3.
        first.next=swapPairs(last.next);
        last.next=first;
        return last;
    }
}
/*

 P0024SwapNodesInParisLinkedList p24 = new P0024SwapNodesInParisLinkedList();
        ListNode node = new ListNode(new int[]{1,2,3,4});
        System.out.println(p24.swapPairs0(node));

这道题目应当是自下而上的思考方式。比如我们有1->2->3->4->5->6->7,应当返回2->1->4->3->6->5->7
两两交换，所以是2->1,4->3,6->5,7.这一步骤可以用记录first，last两个节点并改变指针方向。
之后要将这几段链接在一起，就是1->4,3->6,5->7
我们从最下层得到return的结果7，然后让同一层的5指向7即可，就得到了6指向5指向7.这层结果再return给上一层，让
4指向3指向6，然后再返回到上层
 */

