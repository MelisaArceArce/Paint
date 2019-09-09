import java.awt.*;

public class Pincel {
    private Graphics2D g2d;

    public void dibujaLinea(int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }

    public void setGraphics2D(Graphics2D g2d) {
        this.g2d = g2d;
    }
}
