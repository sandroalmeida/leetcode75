package info.sandroalmeida.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 297. Serialize and Deserialize Binary Tree
 https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 Example 1:
 Input: root = [1,2,3,null,null,4,5]
 Output: [1,2,3,null,null,4,5]
 *
 Example 2:
 Input: root = []
 Output: []
 *
 Example 3:
 Input: root = [1]
 Output: [1]
 *
 Example 4:
 Input: root = [1,2]
 Output: [1,2]
 *
 Constraints:
 The number of nodes in the tree is in the range [0, 104].
 -1000 <= Node.val <= 1000
 */
public class SerializeDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current == null){
                sb.append("N ");
                continue;
            }
            sb.append(current.val + " ");
            queue.add(current.left);
            queue.add(current.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("N ") || data == null) return null;

        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(values[0]));
        queue.add(head);

        for(int i = 1; i < values.length; i++){
            TreeNode current = queue.poll();
            if(!values[i].equals("N")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                current.left = leftNode;
                queue.add(leftNode);
            }
            i++;
            if(!values[i].equals("N")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                current.right = rightNode;
                queue.add(rightNode);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        String serial = serialize(node);
        System.out.println(serial);
        TreeNode deserializedNode = deserialize(serial);
    }
}
