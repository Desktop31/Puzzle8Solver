package com.example.puzzle8;

public class TextMode {

    public static void main(String[] args) {

        String start = "835416270"; // 835416270
        String target = "123804765"; // easy: 123804765, hard: 134862705
        PuzzleMatrix pm = new PuzzleMatrix(3);

        pm.setup(start, target);
        System.out.println("Start: " + start);
        System.out.println("Cíl: " + target);

        PuzzleSolver ps = new PuzzleSolver(pm);

        Node solved = ps.solveLayers();

        System.out.println("Počet kroků: " + solved.depth());
        System.out.println("Počet vygenerovaných uzlů: " + (ps.getHistory().size()-1));
        System.out.println("\nKroky: ");

        System.out.println(solved.printAncestors());
        // ps.printHistory();


    }


}
