import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Random;

public class DrawGraph extends JPanel {
    Bag[] adj;
    public DrawGraph(Bag[] args) {
        this.adj = args;
    }
    @Override
    public void paint(Graphics g){ // method used to create all graphics on the screen
        super.paint(g);
        draw(g);
    }
    public void draw(Graphics g) {
        int numberOfVertices = adj.length;
        HashMap<Integer, Integer[]> verticesCoordinates = new HashMap<Integer, Integer[]>();
        for (int i = 0; i < numberOfVertices; i++) {
            drawVertex(g, verticesCoordinates, i);
        }
        for (int i = 0; i < numberOfVertices; i++) {
            int[] connectedVertices = adj[i].getConnectedVertices();

            for (int j = 0; j < connectedVertices.length; j++) {
                drawEdges(g, verticesCoordinates, i, connectedVertices[j]);
            }
        }
    }

    public void drawVertex(Graphics g, HashMap<Integer, Integer[]> verticesCoordinates, int i){
        Random rand = new Random();
        int x = rand.nextInt(550);
        int y = rand.nextInt(550);
        verticesCoordinates.put(i, new Integer[]{x, y});
        g.drawOval(x, y, 10, 10);

        g.drawString(Integer.toString(i),x,y);
    }
    public void drawEdges(Graphics g, HashMap<Integer, Integer[]> verticesCoordinates, int fromVertex, int toVertex){
        Graphics2D g2 = (Graphics2D) g;
        int x1 = verticesCoordinates.get(fromVertex)[0];
        int y1 = verticesCoordinates.get(fromVertex)[1];

        int x2 = verticesCoordinates.get(toVertex)[0];
        int y2 = verticesCoordinates.get(toVertex)[1];
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }
}
