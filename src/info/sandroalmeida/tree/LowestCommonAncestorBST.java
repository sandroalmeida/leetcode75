package info.sandroalmeida.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * Example 3:
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 * */
public class LowestCommonAncestorBST {

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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p1 = root.left;
        TreeNode q1 = root.right;
        System.out.println(lowestCommonAncestor(root, p1, q1).val);

        TreeNode p2 = root.left.right.left;
        TreeNode q2 = root.left.right.right;
        System.out.println(lowestCommonAncestor(root, p2, q2).val);

        TreeNode p3 = root.left.left;
        TreeNode q3 = root.right.right;
        System.out.println(lowestCommonAncestor(root, p3, q3).val);

        TreeNode p4 = root.left;
        TreeNode q4 = root.left.right.right;
        System.out.println(lowestCommonAncestor(root, p4, q4).val);
    }
}
