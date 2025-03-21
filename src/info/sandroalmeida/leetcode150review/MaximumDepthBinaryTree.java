package info.sandroalmeida.leetcode150review;

public class MaximumDepthBinaryTree {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1);
    tree.left = new TreeNode(2);
    tree.left.left = new TreeNode(3);
    System.out.println(maxDepth(tree));
  }

  public static int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    } else {
      int leftHeight = maxDepth(root.left);
      int rightHeight = maxDepth(root.right);
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
