package com.barras.herramientas;

import javax.swing.*;
import java.awt.*;

/**
 * Botón que simboliza una herramienta
 */
public class BotonHerramienta extends JButton {
    BotonHerramienta(String path) {
        setIcon(new ImageIcon(path));
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(30, 30);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(30, 30);
    }
}
