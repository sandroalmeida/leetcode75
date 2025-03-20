package info.sandroalmeida.leetcode150review;

public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    System.out.println(addTwoNumbers(l1, l2));
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode(0);
    ListNode currentNode = dummyNode;
    int rest = 0;
    while(l1 != null || l2 != null || rest != 0) {
      int val1 = l1 != null ? l1.val : 0;
      int val2 = l2 != null ? l2.val : 0;
      int sum = rest + val1 + val2;
      rest = sum / 10;
      currentNode.next = new ListNode(sum % 10);
      currentNode = currentNode.next;
      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;
    }
    return dummyNode.next;
  }

}
