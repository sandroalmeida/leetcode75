package info.sandroalmeida.educative.grokking_code_interview._2_fast_slow_pointers;

import info.sandroalmeida.educative.grokking_code_interview.LinkedListNode;

public class MiddleNode {
    public static LinkedListNode middleNode(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        System.out.println(middleNode(head).data);
    }
}
