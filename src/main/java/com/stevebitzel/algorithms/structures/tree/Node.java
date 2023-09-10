package com.stevebitzel.algorithms.structures.tree;

public class Node {

    public Node(int n) {
        this.key = n;
    }

    public Node(int n, boolean b) {
        this.key = n;
        this.isRed = b;
        left = Leaf.instance();
        right = Leaf.instance();
    }

    public Node(int i, boolean b, Node left, Node right) {
        this.key = i;
        this.isRed = b;
        this.left = left;
        this.right = right;
        if (this.left != Leaf.instance()) this.left.p = this;
        if (this.right != Leaf.instance()) this.right.p = this;
    }

    public int blackHeight() {
        if (left.isRed) {
            return left.blackHeight();
        } else {
            return 1 + left.blackHeight();
        }
    }

    Node(boolean isRed) {
        this.isRed = isRed;
        this.left = Leaf.instance();
        this.right = left;
        this.p = left;
    }

    protected Node() {
        /* manual construction */
    }

    static Node successor(Node x) {
        Node y;
        if (x.right != Leaf.instance()) {
            return minimum(x.right);
        }
        y = x.p;
        while (y != Leaf.instance() && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }

    static Node minimum(Node x) {
        if (x.left != Leaf.instance()) {
            return minimum(x.left);
        }
        return x;
    }

    public boolean isRed; // color
    int key;
    public Node left;
    public Node right;
    Node p = null; // parent?

    @Override
    public String toString() {
        return key + " (" + (isRed ? "Red" : "Black") + ")";
    }
}
