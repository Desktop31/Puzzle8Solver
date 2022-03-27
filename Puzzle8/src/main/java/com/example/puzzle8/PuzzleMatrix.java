package com.example.puzzle8;

import java.util.Objects;

public class PuzzleMatrix {

    private char[][] matrix;
    private int mSize;
    private String target;


    public PuzzleMatrix(int mSize) {
        this.mSize = mSize;
        this.matrix = new char[mSize][mSize];
    }

    public PuzzleMatrix(int mSize, char[][] matrix, String target) {
        this.mSize = mSize;
        this.matrix = matrix;
        this.target = target;
    }


    public boolean setup(String start, String target) {
        // spatne zadani nebo cil
        if(!checkInput(start, mSize) || !checkInput(target, mSize)) return false;

        this.target = target;

        // naplneni zadanim
        int counter = 0;
        for(int i=0; i < mSize; i++) {
            for(int j=0; j < mSize; j++) {
                matrix[i][j] = start.charAt(counter++);
            }
        }

        return true;
    }


    public static boolean checkInput(String input, int size) {
        // velikost
        if(input.length() != size*size) return false;
        String vals = "123456780";

        // spravne hodnoty
        for (Character ch : vals.toCharArray()) {
            if(input.indexOf(ch) == -1) return false;
        }

        return true;
    }


    public boolean isSolved() {
        return Objects.equals(matToString(), target);
    }


    public boolean up() {
        for(int i=0; i < mSize; i++) {
            for(int j=0; j < mSize; j++) {
                if(matrix[i][j] == '0') {
                    if(i-1 < 0) return false;
                    matrix[i][j] = matrix[i-1][j];
                    matrix[i-1][j] = '0';
                    return true;
                }
            }
        }

        return true;
    }

    public boolean down() {
        for(int i=0; i < mSize; i++) {
            for(int j=0; j < mSize; j++) {
                if(matrix[i][j] == '0') {
                    if(i == mSize-1) return false;
                    matrix[i][j] = matrix[i+1][j];
                    matrix[i+1][j] = '0';
                    return true;
                }
            }
        }

        return true;
    }

    public boolean left() {
        for(int i=0; i < mSize; i++) {
            for(int j=0; j < mSize; j++) {
                if(matrix[i][j] == '0') {
                    if(j-1 < 0) return false;
                    matrix[i][j] = matrix[i][j-1];
                    matrix[i][j-1] = '0';
                    return true;
                }
            }
        }

        return true;
    }

    public boolean right() {
        for(int i=0; i < mSize; i++) {
            for(int j=0; j < mSize; j++) {
                if(matrix[i][j] == '0') {
                    if(j == mSize-1) return false;
                    matrix[i][j] = matrix[i][j+1];
                    matrix[i][j+1] = '0';
                    return true;
                }
            }
        }

        return true;
    }


    public PuzzleMatrix clone() {
        char[][] newMat = new char[mSize][mSize];
        for(int i=0; i < mSize; i++) {
            for(int j=0; j < mSize; j++) {
                newMat[i][j] = matrix[i][j];
            }
        }

        return new PuzzleMatrix(mSize, newMat, target);
    }


    public String matToString() {
        StringBuilder out = new StringBuilder();

        for(int i=0; i < mSize; i++) {
            for(int j=0; j < mSize; j++) {
                out.append(matrix[i][j]);
            }
        }

        return out.toString();
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        //out.append("Size: ").append(mSize);
        //out.append("\nTarget: ").append(target);

        for(int i=0; i < mSize; i++) {
            out.append("\n");
            for(int j=0; j < mSize; j++) {
                out.append("[").append(matrix[i][j]).append("]");
            }
        }

        return out.toString();
    }

    public int getSize() {
        return mSize;
    }
}
