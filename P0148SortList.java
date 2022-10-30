public class P0148SortList {
  public ListNode sortList (ListNode head){
    //Edge Case
    if(head == null || head.next == null){
      return head;
    }
    ListNode p = null;
    ListNode fast = head, slow = head;
    //find out middle node
    while(fast != null && fast.next != null){
      p = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    //cut off linked list into 2 parts
    p.next = null;
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    return merge (l1,l2);
  }

  public ListNode merge (ListNode l1, ListNode l2){
    ListNode l = new ListNode(0);
    ListNode current = l;
    while(l1 != null && l2 != null){
      if(l1.val < l2.val){
        current.next = l1;
        l1 = l1.next;
      }
      else{
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }
    if(l1!=null){
      current.next = l1;
    }
   if(l2 !=null){
      current.next = l2;
    }
    /*
    array需要写成while 循环，但是 linked list不需要，因为其他的节点都是相互连接的
    while(l2 !=null){
      current.next = l2;
      current = current.next;
      l2 = l2.next;
    }
     */

    return l.next;
  }
}
/*
 *
 P0148SortList p148 = new P0148SortList();
 ListNode l = new ListNode(new int[]{-1,5,3,4,0});
 System.out.println(p148.sortList(l));
 */