public class P0002_AddTwoNums {
  public ListNode addTwoNumbers(ListNode l1,ListNode l2){
    //initialize a dummy node
    ListNode dummy = new ListNode(0);
    int sum = 0;
    ListNode current = dummy;
    while(l1 != null || l2 != null){
      if(l1!=null){
        sum+=l1.val;
        l1=l1.next;
      }
      if(l2!=null){
        sum+=l2.val;
        l2=l2.next;
      }
      //留下取余的结果，进位取模
      current.next = new ListNode(sum%10);
      sum/=10;
      current=current.next;
    }
    if(sum==1){
      current.next=new ListNode(1);
    }
    //因为首节点只是dummy结点，值可以放任意，所以要从next开始返回
    return dummy.next;
  }
}
/*
 * P0002_AddTwoNums p2 = new P0002_AddTwoNums();
        ListNode l1 = new ListNode(new int[]{2,4,3});
        ListNode l2 = new ListNode(new int[]{5,6,4});
        System.out.println(p2.addTwoNumbers(l1, l2));
 */