package info.sandroalmeida.tree;

/**
 104. Maximum Depth of Binary Tree
 https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 Given the root of a binary tree, return its maximum depth.
 A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 Example 1:
 Input: root = [3,9,20,null,null,15,7]
 Output: 3
 *
 Example 2:
 Input: root = [1,null,2]
 Output: 2
 *
 Example 3:
 Input: root = []
 Output: 0
 */
public class MaximumDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null)
            return 1;

        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left != null)
            leftDepth = maxDepth(root.left) + 1;
        if(root.right != null)
            rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        System.out.println(maxDepth(tree));
    }
}
