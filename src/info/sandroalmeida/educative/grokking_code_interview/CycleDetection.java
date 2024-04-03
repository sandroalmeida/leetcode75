package info.sandroalmeida.educative.grokking_code_interview;

public class CycleDetection {
    public static boolean detectCycle(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head.next;

        while(fast != null) {
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(detectCycle(head));
    }
}
