package info.sandroalmeida.leetcode75.linkedlist;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Follow up: Could you do this in one pass?
 * */
public class RemoveNthNodeFromEndList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nthNode = head;
        ListNode current = head;
        ListNode previous = head;
        while(n > 0 && nthNode != null){
            nthNode = nthNode.next;
            n--;
        }
        if(nthNode != null){
            while(nthNode != null){
                previous = current;
                current = current.next;
                nthNode = nthNode.next;
            }
            previous.next = current.next;
        } else{
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        
        ListNode result = removeNthFromEnd(listNode, 1);
        while(result != null){
            System.out.print(result.val + "-");
            result = result.next;
        }
    }
}
