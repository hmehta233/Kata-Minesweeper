package test.java.com.bitwiseglobal.minesweeper;

import main.Minesweeper;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by harshm on 7/22/2016.
 */
public class MinesweeperTest {
    @Test
    public void canCreateMinesweeper() throws IOException {
        Minesweeper minesweeper = new Minesweeper("test.txt");
    }


    private void createTestFile(String fileName, String content) throws IOException {

        FileWriter filewriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(filewriter);

        writer.write(content);
        writer.close();

    }

    @Test
    public void canLoadGrid() throws IOException {
        String fileName = "test.txt";
        String content = "1 1\n.";

        createTestFile(fileName, content);

        Minesweeper minesweeper = new Minesweeper(fileName);
        assertEquals(1, minesweeper.getrow());
        assertEquals(1, minesweeper.getcol());
        assertEquals('.', minesweeper.getGrid()[0][0]);


    }

    @Test
    public void canLoadGrid1x2OneMine() throws IOException {
        String fileName = "test.txt";
        String content = "1 2\n*.";

        createTestFile(fileName, content);

        Minesweeper minesweeper = new Minesweeper(fileName);
        assertEquals('*', minesweeper.getGrid()[0][0]);
        assertEquals('.', minesweeper.getGrid()[0][1]);

    }

    @Test

    public void canEvaluate() throws IOException {
        String fileName = "test.txt";
        String content = "1 1\n*";
        createTestFile(fileName, content);

        Minesweeper minesweeper = new Minesweeper(fileName);
        char[][] result = minesweeper.evaluate();
        assertEquals('*', result[0][0]);


}

    @Test

    public void canEvaluate1x2() throws IOException {
        String fileName = "test.txt";
        String content = "1 2\n.*";
        createTestFile(fileName, content);

        Minesweeper minesweeper = new Minesweeper(fileName);
        char[][] result = minesweeper.evaluate();
        assertEquals('1', result[0][0]);
        assertEquals('*', result[0][1]);




    }


    @Test
    public void canEvalaute2x1() throws IOException {
        String fileName = "test.txt";
        String content = "2 1\n*\n.";
        createTestFile(fileName, content);

        Minesweeper minesweeper = new Minesweeper(fileName);
        char[][] result = minesweeper.evaluate();
        assertEquals('*', result[0][0]);
        assertEquals('1', result[1][0]);
    }

    @Test

    public void canEvaluate2x2() throws IOException {
        String fileName = "test.txt";
        String content = "2 2\n..\n**";
        createTestFile(fileName, content);

        Minesweeper minesweeper = new Minesweeper(fileName);
        char[][] result = minesweeper.evaluate();
        assertEquals('2', result[0][0]);
        assertEquals('2', result[0][1]);
        assertEquals('*', result[1][0]);
        assertEquals('*', result[1][1]);

    }

    @Test

    public void canEvaluate3x3() throws IOException {
        String fileName = "test.txt";
//        String content = "2 . 3 \n 2 . .\n1 2 2";
        String content = "3 3\n..\n**";
        createTestFile(fileName, content);

        Minesweeper minesweeper = new Minesweeper(fileName);
        char[][] result = minesweeper.evaluate();

        assertEquals('2', result[0][0]);
        assertEquals('*', result[0][1]);
        assertEquals('3', result[0][2]);
        assertEquals('2', result[1][1]);
        assertEquals('*', result[1][0]);
        assertEquals('*', result[1][2]);
        assertEquals('1', result[2][0]);
        assertEquals('2', result[2][1]);
        assertEquals('2', result[2][2]);

    }

}
