package info.sandroalmeida.educative.grokking_code_interview;

public class RemoveNthLastNode {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {

        LinkedListNode left = head;
        LinkedListNode right = head;

        for(int i = 0; i < n; i++)
            right = right.next;

        if(right == null) return head.next;

        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        LinkedListNode result = removeNthLastNode(head, 6);
        System.out.println(result.data);
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}