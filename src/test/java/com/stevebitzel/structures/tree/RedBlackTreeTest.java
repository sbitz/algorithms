package com.stevebitzel.structures.tree;


import com.stevebitzel.algorithms.structures.tree.Leaf;
import com.stevebitzel.algorithms.structures.tree.Node;
import com.stevebitzel.algorithms.structures.tree.RedBlackTree;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class RedBlackTreeTest {

    private RedBlackTree textbookExample() {
        Node nil = Leaf.instance();
        RedBlackTree tree = new RedBlackTree(
                new Node(11, false,
                        new Node(2, true,
                                new Node(1, false),
                                new Node(7, false,
                                        new Node(5, true),
                                        new Node(8, true))),
                        new Node(14, false, nil,
                                new Node(15, true))));
        verifyRedBlack(tree);
        return tree;
    }

    @Test
    void manualBuild() {
        RedBlackTree tree = textbookExample();
        tree.insert(4);
        verifyRedBlack(tree);
    }

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

        verifyRedBlack(tree);
    }

    @Test
    void insertUnevenLeft() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(11);
        tree.insert(2);
        tree.insert(1);
        verifyRedBlack(tree);
    }

    @Test
    void insertUnevenLeftRight() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(11);
        tree.insert(10);
        tree.insert(9);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        verifyRedBlack(tree);
    }

    @Test
    void deepLeft() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(20);
        tree.insert(19);
        tree.insert(18);
        tree.insert(17);
        tree.insert(16);
        tree.insert(15);
        tree.insert(14);
        tree.insert(13);
        tree.insert(12);
        tree.insert(11);
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        verifyRedBlack(tree);
    }

    @Test
    void testBookCases() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(11);
        tree.insert(2);
        tree.insert(14);
        tree.insert(1);
        tree.insert(7);
        tree.insert(15);
        verifyRedBlack(tree);
    }

    @Test
    void insertUnevenRight() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(11);

        verifyRedBlack(tree);
    }



    private void verifyRedBlack(RedBlackTree tree) {
        Iterator<Node> it = tree.iterator();
        while(it.hasNext()) {
            Node x = it.next();
            if (x.isRed) {
                assert !x.left.isRed;
                assert !x.right.isRed;
            }
        }
    }

}
