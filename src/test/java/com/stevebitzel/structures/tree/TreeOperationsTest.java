package com.stevebitzel.structures.tree;

import com.stevebitzel.algorithms.structures.tree.RedBlackTree;
import org.junit.jupiter.api.Test;


public class TreeOperationsTest {

    @Test
    void insert() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(11);
        tree.insert(2);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);
        tree.insert(4);
        tree.insert(14);
        tree.insert(15);
        tree.insert(8);
        System.out.println(1);

    }

}
