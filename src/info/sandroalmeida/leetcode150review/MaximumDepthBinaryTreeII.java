package info.sandroalmeida.leetcode150review;

import java.util.LinkedList;
import java.util.Stack;

public class MaximumDepthBinaryTreeII {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1);
    tree.left = new TreeNode(2);
    tree.left.left = new TreeNode(3);
    System.out.println(maxDepth(tree));
  }

  public static int maxDepth(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> depths = new Stack<>();
    if(root == null) return 0;

    stack.push(root);
    depths.push(1);

    int depth = 0, current_depth = 0;
    while(!stack.isEmpty()) {
      root = stack.pop();
      current_depth = depths.pop();
      if(root != null) {
        depth = Math.max(depth, current_depth);
        stack.add(root.left);
        stack.add(root.right);
        depths.add(current_depth + 1);
        depths.add(current_depth + 1);
      }
    }
    return depth;
  }
}
