import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Botón de color que aparece en la barra de colores
 */
public class BotonColor extends JButton {
    private static BarraColores barra;
    private static SelectorColor selector;

    BotonColor(Color color, BarraColores barra) {
        BotonColor.barra = barra;
        setBackground(color);

        selector = new SelectorColor();

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) { // Detecta si se hizo doble clic
                    e.consume();

                    selector.creaDialogo();

                    if (selector.color != null) {
                        setBackground(selector.color);
                    }
                } else if (e.getClickCount() == 1 && !e.isConsumed()) {
                    e.consume();

                    barra.setColorActivo(color);
                }
            }
        };

        addMouseListener(ma);
    }

    public Dimension getMaximumSize() {
        return new Dimension(20, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(20, 20);
    }
}
