package info.sandroalmeida.leetcode150review;

public class MergeTwoSortedLists {
  public static void main(String[] args) {
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(3);
    list1.next.next = new ListNode(5);

    ListNode list2 = new ListNode(0);
    list2.next = new ListNode(2);
    list2.next.next = new ListNode(4);

    mergeTwoLists(list1, list2);
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummyNode = new ListNode(0);
    ListNode current = dummyNode;
    while(list1 != null || list2 != null) {
      if(list1 != null && list2 != null) {
        if(list1.val < list2.val) {
          current.next = new ListNode(list1.val);
          list1 = list1.next;
        } else{
          current.next = new ListNode(list2.val);
          list2 = list2.next;
        }
      } else if(list1 == null) {
        current.next = new ListNode(list2.val);
        list2 = list2.next;
      } else{
        current.next = new ListNode(list1.val);
        list1 = list1.next;
      }
      current = current.next;
    }
    return dummyNode.next;
  }
}
