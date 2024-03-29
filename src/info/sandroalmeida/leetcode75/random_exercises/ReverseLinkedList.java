package info.sandroalmeida.leetcode75.random_exercises;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val).append("-");
        ListNode current = this;
        while(current.next != null) {
            sb.append(current.next.val).append("-");
            current = current.next;
        }
        return sb.toString();
    }
}
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head.next == null) return head;
        ListNode current = head.next;
        ListNode previous = head;
        head.next = null;
        while(current.next != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        current.next = previous;
        return current;
    }

    public static void main(String[] args) {
        ListNode newNode = new ListNode(1);
        newNode.next = new ListNode(2);
        newNode.next.next = new ListNode(3);
        newNode.next.next.next = new ListNode(4);
        newNode.next.next.next.next = new ListNode(5);

        System.out.println(newNode);
        ListNode reversed = reverseList(newNode);
        System.out.println(reversed);
    }
}
