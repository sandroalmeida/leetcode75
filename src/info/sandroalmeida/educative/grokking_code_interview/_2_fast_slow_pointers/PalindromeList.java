package info.sandroalmeida.educative.grokking_code_interview._2_fast_slow_pointers;

import info.sandroalmeida.educative.grokking_code_interview.LinkedListNode;

public class PalindromeList {
    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode previous = null;
        // using two pointers to find the middle
        while(fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // splitting the linkedlist in two
        if(previous != null) previous.next = null;

        // reverting second half and
        // using two pointer at same speed to compare to halves
        LinkedListNode p1 = revertLinkedList(slow);
        LinkedListNode p2 = head;
        while(p1 != null && p2 != null) {
            if(p1.data != p2.data) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private static LinkedListNode revertLinkedList(LinkedListNode head) {
        LinkedListNode previous = null;
        LinkedListNode current = head;
        while(current != null) {
            LinkedListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(1);
        System.out.println(palindrome(head));
    }
}
