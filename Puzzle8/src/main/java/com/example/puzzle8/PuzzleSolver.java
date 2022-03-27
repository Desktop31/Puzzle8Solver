package com.example.puzzle8;

import java.util.ArrayList;

public class PuzzleSolver {

    private Node firstNode;
    private ArrayList<Node> history;
    MyQueue<Node> toCheck;

    public PuzzleSolver(PuzzleMatrix matrix) {
        this.firstNode = new Node(matrix);
        this.history = new ArrayList<>();
        history.add(firstNode);
        this.toCheck = new MyQueue<>();
        toCheck.add(firstNode);
    }

    public ArrayList<Node> getHistory() {
        return history;
    }

    public int getStepsCount() {
        return firstNode.depth();
    }


    public Node solveLayers() {

        while (!toCheck.isEmpty()) {
            checkLayer();
        }

        return firstNode;
    }

    private void checkLayer() {
        Node curNode = toCheck.remove();
        if(curNode.getMatrix().isSolved()) {
            history.add(curNode);
            firstNode = curNode;
            toCheck.empty();
            return;
        }

        Node nodeUp = new Node(curNode.getMatrix().clone(), curNode);
        if(nodeUp.getMatrix().up()) {
            if(!inHistory(nodeUp.getMatrix())) {
                toCheck.add(nodeUp);
                history.add(nodeUp);
            }
        }

        Node nodeLeft = new Node(curNode.getMatrix().clone(), curNode);
        if(nodeLeft.getMatrix().left()) {
            if(!inHistory(nodeLeft.getMatrix())) {
                toCheck.add(nodeLeft);
                history.add(nodeLeft);
            }
        }

        Node nodeRight = new Node(curNode.getMatrix().clone(), curNode);
        if(nodeRight.getMatrix().right()) {
            if(!inHistory(nodeRight.getMatrix())) {
                toCheck.add(nodeRight);
                history.add(nodeRight);
            }
        }

        Node nodeDown = new Node(curNode.getMatrix().clone(), curNode);
        if(nodeDown.getMatrix().down()) {
            if(!inHistory(nodeDown.getMatrix())) {
                toCheck.add(nodeDown);
                history.add(nodeDown);
            }
        }

    }

    private boolean inHistory(PuzzleMatrix p) {
        for (Node n : history) {
            if(n.getMatrix().matToString().equals(p.matToString())) return true;
        }

        return false;
    }

    public String showStep(String step) {
        StringBuilder out = new StringBuilder();

        for(int i=0; i < step.length(); i++) {
            if(i % firstNode.getMatrix().getSize() == 0 && i != 0) out.append("\n");
            out.append("[");
            out.append(step.charAt(i));
            out.append("]");
        }

        return out.toString();
    }

    public void printHistory() {
        for(int i=0; i < history.size(); i++) {
            System.out.println("Step: " + i + "\n" + showStep(history.get(i).getMatrix().matToString()));
        }
    }

    private String printQueue() {
        StringBuilder out = new StringBuilder("[");
        for (Node n : toCheck.getQueue()) {
            out.append(n.getMatrix().matToString()).append(", ");
        }

        return out.append("]").toString();
    }

}
