package info.sandroalmeida.tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 * */
public class kthSmallestElementBST {

    public static Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static int kthSmallest(TreeNode root, int k) {
        traverseBST(root, k);
        return maxHeap.peek();
    }

    public static void traverseBST(TreeNode node, int k) {
        if(maxHeap.size() < k){
            maxHeap.add(node.val);
        } else{
            if(node.val < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(node.val);
            }
        }
        if(node.left != null) traverseBST(node.left, k);
        if(node.right != null) traverseBST(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(kthSmallest(root, 3));
    }
}
