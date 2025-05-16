package ru.itis.aasd;

public class Task2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        String treeStr = serialize(root);
        System.out.println(treeStr);
    }

    public static String serialize(TreeNode node) {
        if (node == null) return "NULL";

        String left = serialize(node.left);
        String right = serialize(node.right);

        return "(" + node.value + ", " + left + ", " + right + ")";
    }
}
