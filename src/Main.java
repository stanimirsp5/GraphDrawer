import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "/Users/stanimir/GraphDrawer/src/sources/mediumG.txt"; //teenyWeenyG,tinyG,mediumG
        In in = new In(pathName);
        Graph g = new Graph(in);

        Bag[] bag = g.getList();


        JFrame frame = new JFrame();
        frame.setTitle("Draw String Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new DrawGraph(bag));
        frame.pack();
        frame.setSize(620, 620);
        frame.setVisible(true);
    }
}