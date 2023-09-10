package com.stevebitzel.algorithms.structures.tree;

import java.util.*;

import static com.stevebitzel.algorithms.structures.tree.Node.successor;


/**
 * Balanced search tree to guarantee basic operations are O(logN) and guarantees no path is more than 2x longer than any
 * other.
 *
 * <ol>
 *     <li> Each node is colored red or black
 *     <li> The root is black
 *     <li> leaves are black
 *     <li> if a node is red, its children are black
 *     <li> For each node, all paths from the node to leaves contain the same number of black nodes
 * </ol>
 *
 */
public class RedBlackTree extends BinaryTree {

    public RedBlackTree(Node node) {
        root = node;
        root.p = nil;
    }

    public void insert(int n) {
        Node z = new Node(n);
        Node y = nil;
        Node x = root;
        while (x != nil) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == nil) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = nil;
        z.right = nil;
        z.isRed = true;
        rbInsertFixup(this, z);
    }

    public Node delete(Node z) {
        Node y = nil;
        Node x = nil;
        if (z.left == nil || z.right == nil) {
            y = z;
        } else {
            y = successor(z);
        }
        if (y.left != nil) {
            x = y.left;
        } else {
            x = y.right;
        }
        if (y.p == nil) {
            root = x;
        } else if ( y == y.p.left) {
            y.p.left = x;
        } else {
            y.p.right = x;
        }
        if (y != z) {
            z.key = y.key; // todo copy other y info into z
        }
        if (!y.isRed)
            rbDeleteFixup(this, x);
        return y;

    }

    public RedBlackTree() {
        root = nil;
    }

    private void rbInsertFixup(RedBlackTree t, Node z) {
        Node y = nil;
        while (z.p.isRed) {
            if (z.p == z.p.p.left) { // parent is a right node
                y = z.p.p.right; // uncle
                if (y.isRed) {
                    z.p.isRed = false;
                    y.isRed = false;
                    z.p.p.isRed = true;
                    z = z.p.p;
                } else if (z == z.p.right) {
                    z = z.p;
                    leftRotate(z);
                } else {
                    z.p.isRed = false;
                    z.p.p.isRed = true;
                    rightRotate(z.p.p);
                }
            } else {
                y = z.p.p.left;
                if (y.isRed) {
                    z.p.isRed = false;
                    y.isRed = false;
                    z.p.p.isRed = true;
                    z = z.p.p;
                } else if (z == z.p.left) {
                    z = z.p;
                    rightRotate(z);
                } else {
                    z.p.isRed = false;
                    z.p.p.isRed = true;
                    leftRotate(z.p.p);
                }
            }
        }
        root.isRed = false;
    }

    private void rbDeleteFixup(RedBlackTree t, Node z) {
        Node x = nil;
        while (x != t.root && !x.isRed) {
            if (x == x.p.left) {

            } else {
                
            }
        }
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != Leaf.instance()) {
            y.left.p = x;
        }
        y.p = x.p;
        if (x.p == Leaf.instance()) {
            root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.left = x;
        x.p = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != Leaf.instance()) {
            x.right.p = y;
        }
        x.p = y.p;
        if (y.p == Leaf.instance()) {
            root = x;
        } else if (y == y.p.right) {
            y.p.right = x;
        } else {
            y.p.left = x;
        }
        x.right = y;
        y.p = x;
    }

    public Iterator<Node> iterator() {
        return new Iterator<>() {

            Deque<Node> nodeStack = new LinkedList<>();
            {
                nodeStack.push(root);
            }

            @Override
            public boolean hasNext() {
                if (nodeStack.isEmpty()) return false;
                return nodeStack.peek() != nil;
            }

            @Override
            public Node next() {
                Node x = nodeStack.pop();
                if (x.left != nil) nodeStack.push(x.left);
                if (x.right != nil) nodeStack.push(x.right);
                return x;
            }
        };
    }
    public Node root;
    Node nil = Leaf.instance();
}

