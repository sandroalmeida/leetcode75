package info.sandroalmeida.leetcode75.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Example 2:
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 * */
public class BinaryTreeMaximumPathSum {

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

    static class NodeInfo{
        int sumPath;
        int sumLeft;
        int sumRight;

        public NodeInfo(int sumPath, int sumLeft, int sumRight) {
            this.sumPath = sumPath;
            this.sumLeft = sumLeft;
            this.sumRight = sumRight;
        }
    }

    public static int maxPathSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, NodeInfo> mapNodes = new HashMap<>();
        NodeInfo rootInfo = helper(root, mapNodes);
        int maxSum = Integer.MIN_VALUE;
        for(Map.Entry<TreeNode, NodeInfo> item: mapNodes.entrySet())
            maxSum = Math.max(item.getValue().sumPath, maxSum);
        return maxSum;
    }

    public static NodeInfo helper(TreeNode root, Map<TreeNode, NodeInfo> mapNodes) {

        if(root.left ==  null && root.right == null){
            NodeInfo nodeInfo = new NodeInfo(root.val, 0, 0);
            mapNodes.put(root, nodeInfo);
            return nodeInfo;
        }
        int maxLeft = 0;
        NodeInfo nodeInfoLeft;
        int maxRight = 0;
        NodeInfo nodeInfoRight;

        if(root.left != null){
            nodeInfoLeft = helper(root.left, mapNodes);
            maxLeft = Math.max(nodeInfoLeft.sumLeft, nodeInfoLeft.sumRight) + root.left.val;
        }

        if(root.right != null){
            nodeInfoRight = helper(root.right, mapNodes);
            maxRight = Math.max(nodeInfoRight.sumLeft, nodeInfoRight.sumRight) + root.right.val;
        }

        NodeInfo nodeInfo = new NodeInfo(maxLeft + maxRight + root.val, maxLeft, maxRight);
        mapNodes.put(root, nodeInfo);
        return nodeInfo;

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(9);
        tree.right = new TreeNode(12);
        tree.right.left = new TreeNode(11);
        tree.right.right = new TreeNode(14);

        System.out.println(maxPathSum(tree));
    }
}
