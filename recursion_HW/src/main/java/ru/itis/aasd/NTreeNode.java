package ru.itis.aasd;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode {
    int value;
    List<NTreeNode> children;


    public NTreeNode(int value){
        this.value = value;
        this.children = new ArrayList<>();
    }
}