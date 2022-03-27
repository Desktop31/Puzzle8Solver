package com.example.puzzle8;

import java.util.ArrayList;

public class Node {

    private Node parent;
    private PuzzleMatrix matrix;

    public Node(PuzzleMatrix matrix) {
        this.parent = null;
        this.matrix = matrix;
    }

    public Node(PuzzleMatrix matrix, Node parent) {
        this.parent = parent;
        this.matrix = matrix;
    }

    public Node getParent() {
        return parent;
    }

    public PuzzleMatrix getMatrix() {
        return matrix;
    }

    public int depth() {
        int depth = 0;
        Node parent = this.parent;

        while (parent != null) {
            parent = parent.getParent();
            depth++;
        }
        return depth;
    }

    public String printAncestors() {
        int depth = depth();
        StringBuilder out = new StringBuilder("Step: " + depth);
        out.append(matrix);
        Node parent = this.parent;

        while (parent != null) {
            out.append("\nStep: " + --depth).append(parent.getMatrix());
            parent = parent.getParent();
        }

        return out.toString();
    }

    public ArrayList<String> getAncestors() {
        ArrayList<String> out = new ArrayList<>();
        out.add(matrix.matToString());
        Node parent = this.parent;

        while (parent != null) {
            out.add(parent.getMatrix().matToString());
            parent = parent.getParent();
        }

        return out;
    }


    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", matrix=" + matrix +
                '}';
    }
}
