public class P0160IntersectionOfTwoLinkedLists {
  // 方法1
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //记录l1,l2的节点个数
    int countL1=0;
    int countL2=0;
    ListNode curheadA = headA;
    ListNode curheadB = headB;
    while(curheadA!=null || curheadB !=null){
        if(curheadA !=null){
            countL1++;
            curheadA = curheadA.next;

        }
        if(curheadB!=null){
            countL2++;
            curheadB = curheadB.next;
        }
    }
    ListNode currentHeadA = headA;
    ListNode currentHeadB = headB;
    //若l1节点数更多，则先走多出来的步数
    if(countL1>countL2){
      for(int i = 0; i<countL1-countL2;i++){
        currentHeadA=currentHeadA.next;
      }
    }
    //若l2节点数更多，则先让l2走多出来的步数
    if(countL1<countL2){
      for(int i = 0; i<countL2-countL1;i++){
        currentHeadB = currentHeadB.next;
      }
    }
    //此时l1,l2剩余的节点数一致，所以同时走的情况下若没有交叉点，则其中一个走到了null，另一个也是null。
    //若有交叉点，则返回指向同一个的节点即可
    while(currentHeadA != currentHeadB && currentHeadA!=null && currentHeadB!=null){
      currentHeadA=currentHeadA.next;
      currentHeadB = currentHeadB.next;
    }
   return currentHeadA;
  }

  //方法2
  public ListNode getIntersectionNode1(ListNode headA,ListNode headB){
    if(headA == null || headB==null) return null;
    ListNode p1 = headA;
    ListNode p2 = headB;
    while(p1 != p2){
      // p1,p2 both refer to null也是成立的，也视为p1=p2。会停止循环。
      p1 = (p1 == null)? headB:p1.next;
      p2 = (p2 == null)? headA:p2.next;
    }
    return p1;
  }
}

/*
如果直接new linked list，那么是两条不同的linked list，不会有交叉点。所以只能用单独new 新的 节点的方式
 P0160IntersectionOfTwoLinkedLists p160 = new P0160IntersectionOfTwoLinkedLists();
        ListNode intersectListNode = new ListNode(8);
        intersectListNode.next = new ListNode(4);
        intersectListNode.next.next = new ListNode(5);
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = intersectListNode;
        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(1);
        l2.next.next.next = intersectListNode;
        System.out.println(p160.getIntersectionNode(l1, l2));
 */