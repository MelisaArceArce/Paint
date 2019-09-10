import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Lienzo donde se puede dibujar
 * Se encarga de ver los cambios al trazar con el mouse
 */

public class Lienzo extends JPanel {
    private List<List<Point>> puntos;

    Lienzo(Pincel pincel) {
        puntos = new ArrayList<>(25);

        setBackground(Color.white);

        MouseAdapter ma = new MouseAdapter() {
            private List<Point> caminoActual;

            @Override
            public void mousePressed(MouseEvent e) {
                caminoActual = new ArrayList<>(25);
                caminoActual.add(e.getPoint());

                puntos.add(caminoActual);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point puntoArrastrado = e.getPoint();
                caminoActual.add(puntoArrastrado);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                caminoActual = null;
            }
        };

        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        for (List<Point> camino : puntos) {
            Point desde = null;
            for (Point hasta : camino) {
                if (desde != null) {
                    g2d.drawLine(desde.x, desde.y, hasta.x, hasta.y);
                }
                desde = hasta;
            }
        }
        g2d.dispose();
    }
}
