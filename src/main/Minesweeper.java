package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by harshm on 7/25/2016.
 */
public class Minesweeper {

    private int col;
    private int row;
    private char[][] grid;

    public Minesweeper(String filename) throws IOException {

        FileReader filereader = new FileReader("test.txt");
        BufferedReader bufferedreader = new BufferedReader(filereader);
        String line = bufferedreader.readLine();
        String[] dimension = line.split(" ");

        row = Integer.parseInt(dimension[0]);
        col = Integer.parseInt(dimension[1]);

        if (row > 0 && col > 0) {
            grid = new char[row][col];
            for (int i = 0; i < row; i++) {
                line = bufferedreader.readLine();
                for (int j = 0; j < col; j++)
                    grid[i][j] = line.charAt(j);
            }
        }

    }

    public int getcol() {
        return col;
    }

    public int getrow() {
        return row;
    }

    public char[][] getGrid() {
        return grid;
    }

    public char[][] evaluate() {
        char[][] result = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '.') {
                    result[i][j] = '0';
                    int count = 0;

                    if (west(j) && grid[i][j - 1] == '*') {
                        count++;
                    }
                    if(east(j) && grid[i][j+1]=='*'){
                        count++;
                    }
                    if(south(i) && grid [i+1][j] =='*'){
                        count++;
                    }
                    if(north(i) && grid [i-1][j]=='*'){
                        count++;
                    }
                    if(north(i) && east(j) && grid[i-1][j+1]=='*'){
                        count++;
                    }
                    if(north(i) && east(j)&& grid[i-1][j-1]=='*'){
                        count++;
                    }
                    if(south(i) && east(j)&& grid[i+1][j+1]=='*'){
                        count++;
                    }
                    if(south(i) && west(j) && grid[i+1][j-1]=='*'){
                        count++;
                    }
                    result[i][j] = Character.forDigit(count, 10);
                } else {
                    result[i][j] = grid[i][j];

                }
            }
        }

                return result;
            }

    private boolean north(int i) {
        return i-1>-1;
    }

    private boolean south(int i) {
        return i+1<row;
    }

    private boolean east(int j) {
        return j+1<col;
    }

    private boolean west(int j) {
        return j - 1 > -1;
    }
}


