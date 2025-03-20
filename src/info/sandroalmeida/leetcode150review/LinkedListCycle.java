package info.sandroalmeida.leetcode150review;

public class LinkedListCycle {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = head.next;

    System.out.println(hasCycle(head));
  }

  public static boolean hasCycle(ListNode head) {
    if(head == null) return false;

    ListNode slow = head, fast = head.next;
    while(fast != null && fast.next != null) {
      if(slow == fast)
        return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
