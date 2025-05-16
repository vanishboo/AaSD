package ru.itis.aasd;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Map<TreeNode, Integer> result = new HashMap<>();
        getHeights(root, result);
        print(result, root);
    }

    public static int getHeights(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return -1;

        int l = getHeights(node.left, map);
        int r = getHeights(node.right, map);
        int h = 1 + Math.max(l, r);

        map.put(node, h);
        return h;
    }

    public static void print(Map<TreeNode, Integer> map, TreeNode node) {
        if (node == null) return;

        System.out.println("Node " + node.value + " -> высота = " + map.get(node));
        print(map, node.left);
        print(map, node.right);
    }
}

