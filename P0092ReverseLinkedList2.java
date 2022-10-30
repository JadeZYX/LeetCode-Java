
public class P0092ReverseLinkedList2 {
  public ListNode reverseBetween(ListNode head,int left,int right){
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    int step = 1;
    while(step<left){
      p=p.next;
      step++;
    }
    ListNode previousNode = p;//1
    ListNode fromNode = p.next;//2
    while(left<=right){
      p=p.next;
      left++;
    }
    ListNode toNode = p;//4
    ListNode nextNode = p.next;//5
    toNode.next = null;//需要把to指向null
     p = fromNode;//需要reverse的起点
    while(fromNode!=null){
      ListNode temp = fromNode.next;
      fromNode.next = nextNode;//2指向5
      nextNode = fromNode;
      fromNode = temp;
    }
    previousNode.next = nextNode;//1指向4
    return dummy.next;
  }
}




/*
 * 把整个Linked list分成三段。记录四个点，previous,from,to,next. from到to代表需要reverse的部分。
 * corner case： left=right的时候不需要reverse。 如果left=1，则从头开始返转。此时就没有previous，所以多设置一个dummy节点，避免previous和from的重合。
 */