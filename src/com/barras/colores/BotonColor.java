package com.barras.colores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Botón de color que aparece en la barra de colores
 */
public class BotonColor extends JButton {
    private static SelectorColor selector;

    BotonColor(Color color) {
        setBackground(color);

        selector = new SelectorColor();

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    selector.creaDialogo();

                    if (selector.color != null) {   // Cambia el color del botón
                        setBackground(selector.color);
                    }
                } else if (e.getClickCount() == 1 && !e.isConsumed()) {
                    e.consume();
                    BarraColores.botonActivo = (BotonColor) e.getSource(); // Selecciona un color
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

    @Override
    protected void paintComponent(Graphics g) {
        if (BarraColores.botonActivo == this) {
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        } else {
            setBorder(new JButton().getBorder());
        }
        super.paintComponent(g);
    }
}
