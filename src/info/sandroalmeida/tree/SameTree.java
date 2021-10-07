package info.sandroalmeida.tree;

public class SameTree {
    
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q == null) return false;
        if(q != null && p == null) return false;
        if(q == null && p == null) return true;
        if(p.val != q.val) return false;

        boolean isSameLeft;
        boolean isSameRight;
        isSameLeft = isSameTree(p.left, q.left);
        isSameRight = isSameTree(p.right, q.right);
        return isSameLeft && isSameRight;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println(isSameTree(tree1, tree2));
    }
}
