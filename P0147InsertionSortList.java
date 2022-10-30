public class P0147InsertionSortList {
  public ListNode insertionSortList0(ListNode head){
    if(head == null) return head;
    ListNode previous = head;
    ListNode current = head.next;
    //因为current在previous之后，所以只要确保current存在即可
    while(current!=null){
      if(current.val >= previous.val){
        current = current.next;
        previous = previous.next;
      }
      else{
        previous.next = current.next;
        if(current.val <= head.val){
          current.next = head;
          head = current;
        }
        else{
          ListNode search = head;
          while(search.next != null && search.next.val < current.val){
            search = search.next;
          }
          ListNode temp = search.next;
          search.next = current;
          current.next = temp;
        }
        current = previous.next;
      }
    }
    return head;
  }


   public ListNode insertionSortList(ListNode head){
     //edge case
     if(head == null) return null;
     //set previous, and current pointers and current node should 1 step forward previous
     ListNode prev = head;
     ListNode cur = head.next;
     while(cur != null){
       if(cur.val >= prev.val){
         cur = cur.next;
         prev = prev.next;
       }
       //cur.val < prev.val
       else{
            prev.next = cur.next;
         //compare current value and head value
           //if current value smaller than head's value,just change current as new head
         if(cur.val <= head.val){
           //这里current的next指向了原来的head，那么原来current next后面的链表被断开了，所以要改变previous的指针指向current的next
           cur.next = head;
           head = cur;
         }
         //current value larger than head's value,那么iterate nodes after head and find out
         //right position to insert the current value
         else{
           ListNode search = head;
             while(search.next != null){
                if(search.val <=cur.val && search.next.val >= cur.val){
                    cur.next = search.next;
                    search.next = cur;
                    break;
                 }
                 else{
                     search = search.next;
                 }
             }
         }
         cur = prev.next;
       }
     }
     return head;
   }
}
/*
 *
 P0147InsertionSortList p147 = new P0147InsertionSortList();
         ListNode head = new ListNode(new int[]{-1,5,3,4,0});
         System.out.println(p147.insertionSortList(head));
 */