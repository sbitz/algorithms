package com.stevebitzel.algorithms.structures.tree;

public class Leaf extends Node {

    @Override
    public int blackHeight() {
        return 0;
    }

    private static Leaf instance = null;

    public static Node instance() {
        if (instance == null)
            instance = new Leaf();
        return instance;
    }

    private Leaf() {
        super();
        isRed = false;

    }

    @Override
    public String toString() {
        return "nil (Black)";
    }
}
