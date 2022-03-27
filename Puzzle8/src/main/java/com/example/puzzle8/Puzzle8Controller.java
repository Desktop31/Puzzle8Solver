package com.example.puzzle8;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Puzzle8Controller {

    @FXML
    private TextField start, goal;

    @FXML
    private Label stepCount, nodeCount;

    @FXML
    private GridPane startGrid, goalGrid, solvedGrid;

    @FXML
    private Button solveBtn, prevBtn, nextBtn;

    private int current = 0;

    private ArrayList<String> nodes;


    @FXML
    protected void enterStart() {
        String input = start.getText();
        setGrid(startGrid, input);
    }

    @FXML
    protected void enterGoal() {
        String input = goal.getText();
        setGrid(goalGrid, input);
    }

    @FXML
    protected void solve() {
        PuzzleMatrix pm = new PuzzleMatrix(3);

        boolean success = pm.setup(start.getText(), goal.getText());
        if (!success) return;
        solveBtn.setDisable(true);

        PuzzleSolver ps = new PuzzleSolver(pm);

        com.example.puzzle8.Node solved = ps.solveLayers();

        stepCount.setText(String.valueOf(solved.depth()));
        nodeCount.setText(String.valueOf(ps.getHistory().size()-1));
        nextBtn.setDisable(true);
        nodes = solved.getAncestors();
        String s = nodes.get(current);
        setGrid(solvedGrid, s);
        prevBtn.setDisable(false);
        solveBtn.setDisable(false);

    }

    @FXML
    protected void showPrev() {
        if (current == Integer.parseInt(stepCount.getText())) {
            prevBtn.setDisable(true);
            return;
        }
        current++;
        if (current == Integer.parseInt(stepCount.getText())) prevBtn.setDisable(true);
        nextBtn.setDisable(false);

        String s = nodes.get(current);
        setGrid(solvedGrid, s);
    }

    @FXML
    protected void showNext() {
        if (current == 0) {
            nextBtn.setDisable(true);
            return;
        }
        current--;
        if (current == 0) nextBtn.setDisable(true);
        prevBtn.setDisable(false);

        String s = nodes.get(current);
        setGrid(solvedGrid, s);
    }

    private void setGrid(GridPane grid, String string) {
        if (!PuzzleMatrix.checkInput(string, 3)) return;
        if (string.length() != 9) return;

        ObservableList<Node> labels = grid.getChildren();

        for (int i=0; i < 9; i++) {
            ((Label) labels.get(i)).setText(String.valueOf(string.charAt(i)));
        }
    }

}