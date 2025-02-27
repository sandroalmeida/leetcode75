package info.sandroalmeida.leetcode75.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 572. Subtree of Another Tree
 https://leetcode.com/problems/subtree-of-another-tree/
 *
 Given the roots of two binary trees root and subRoot,
 return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 The tree tree could also be considered as a subtree of itself.
 *
 Example 1:
 Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 Output: true
 *
 Example 2:
 Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 Output: false
 *
 Constraints:
 The number of nodes in the root tree is in the range [1, 2000].
 The number of nodes in the subRoot tree is in the range [1, 1000].
 -104 <= root.val <= 104
 -104 <= subRoot.val <= 104
 */
public class SubTreeAnotherTree {
    
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

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode current;
        while(!queue.isEmpty()){
            current = queue.poll();
            if(current.val == subRoot.val && traverseChecking(current, subRoot)){
                return true;
            }
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);

        }
        return false;
    }

    public static boolean traverseChecking(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;

        boolean leftCheck = traverseChecking(root.left, subRoot.left);
        boolean rightCheck = traverseChecking(root.right, subRoot.right);

        return leftCheck && rightCheck;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        TreeNode subRoot = new TreeNode(4);
//        subRoot.left = new TreeNode(1);
//        subRoot.right = new TreeNode(2);
//        subRoot.right.left = new TreeNode(0);

        System.out.println(isSubtree(root, subRoot));
    }
}
