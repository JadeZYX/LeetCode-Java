import java.util.ArrayList;

public class P0234PalindromeLinkedList {
  public boolean isPalindrome(ListNode head){
    if(head == null || head.next ==null)return true;
    ListNode slow = head;
    ListNode fast = head;
    //取中间位置
    while(fast != null && fast.next != null){//若fast is null, then fast.next is null, so here can't use or ||
      fast = fast.next.next;
      slow = slow.next;
    }
    //reverse后半部分的链表，起点是slow指针所在的位置
    ListNode previous = null;
    ListNode current = slow;
    while(current != null){
      ListNode temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }
    //判断前段和reverse后的后半段的值是否一致
    ListNode p = head;
    while(previous!=null){//reverse 后的链表的头节点
      if(p.val != previous.val){
        return false;
      }
      p = p.next;
      previous=previous.next;
    }
    return true;
  }
// 第二种方法，遍历整个linked list，然后存在array list里面，再用双向指针判定是否是回文
  public boolean isPalindrome1(ListNode head){
    //corner case
    if(head == null || head.next == null) return true;
    //store values into list
    ArrayList<Integer>list = new ArrayList<>();
    ListNode p = head;
    while(p!=null){
      list.add(p.val);
      p=p.next;
    }
    int left = 0, right = list.size()-1;
    while(left < right){
      if(list.get(left)!=list.get(right)){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  //第三种写法 整体思路一致，只是分成独立的function
  public boolean isPalindrome2(ListNode head){
    if(head == null || head.next == null) return true;
    //find middle node
    ListNode middleNode = findMiddle(head);
    ListNode rightPartHead = reverse(middleNode);
    ListNode p = head, q = rightPartHead;
    while(q!=null && p!=null){
      if(p.val != q.val){
        return false;
      }
      q = q.next;
      p = p.next;
    }
    return true;
  }
  public ListNode findMiddle(ListNode head){
    ListNode slow = head, fast = head;
    while(fast!= null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    if(fast == null) return slow;
    return slow.next; //fast.next == null
  }
  public ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev=head;
      head=next;
    }
    return prev;
  }
}


/*
 * 这道题目是判定linked list是否是回文。暴力解法是遍历链表，把值存入List里，然后再用双向指针看list里存放的值是否是前后对应的。但是本题目有空间时间复杂度的限制，要求O(n)time + O(1)space，所以我们可以用快慢指针先找到链表的中间位置，然后reverse中间位置后的那段链表，再同时遍历前后段链表查看对应值是否一致。
 * 如果链表是双数 1-2-2-1， 则slow中间点会落在中间偏右，也就是第二个节点2的位置
 * 如果链表是单数 1-2-3-2-1， 则slow正好落在中间位置3上面
 */