import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener {
    private BrickLayout b;
    private long startTime = System.currentTimeMillis();
    private int counter = 0;

    public DrawPanel() {
        this.addMouseListener(this);
        b = new BrickLayout("src/bricks", 40, false);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] grid = b.getBrickLayout();

        if (grid == null) {
            return;
        }

        int gridRows = grid.length;
        int gridCols = grid[0].length;

        int x;
        int y = 10;
        for (int c = 0; c < gridRows; c++) {
            x = 10;

            for (int r = 0; r < gridCols; r++) {
                g.drawRect(x, y, 20, 20);
                x += 25;
        }
        y += 25;
    }

    int rate = 1;
    int timeInterval = 100;
    long currentTime = System.currentTimeMillis();

        if (currentTime - startTime >= timeInterval/rate) {
            counter++;
            if (counter == rate) {
            b.doOneBrick();
            counter = 0;
            }
            b.bricksFalling();
            startTime = currentTime;
        }

        Graphics2D g2 = (Graphics2D) g;

        int x1;
        int y1 = 10;

        for (int r = 0; r < gridRows; r++) {
            x1 = 10;
            for (int c = 0; c < gridCols; c++) {
                if (grid[r][c] == 1) {
                    g2.setColor(Color.red);
                    g2.fillRect(x1, y1, 20, 20);
                    g2.setColor(Color.black);
                }
             x1 += 25;
        }
        y1 += 25;
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
