package ru.itis.aasd;

public class Task3 {
    public static void main(String[] args) {
        NTreeNode root = new NTreeNode(1);
        root.children.add(new NTreeNode(2));
        root.children.add(new NTreeNode(3));
        root.children.add(new NTreeNode(4));

        root.children.get(0).children.add(new NTreeNode(5));
        root.children.get(2).children.add(new NTreeNode(6));
        root.children.get(2).children.add(new NTreeNode(7));

        String output = serialize(root);
        System.out.println(output);
    }

    public static String serialize(NTreeNode node) {
        if (node == null) return "NULL";

        StringBuilder sb = new StringBuilder();
        sb.append("(").append(node.value);

        if (node.children.isEmpty()) {
            sb.append(", NULL");
        } else {
            for (int i = 0; i < node.children.size(); i++) {
                sb.append(", ").append(serialize(node.children.get(i)));
            }
        }

        sb.append(")");
        return sb.toString();
    }
}
