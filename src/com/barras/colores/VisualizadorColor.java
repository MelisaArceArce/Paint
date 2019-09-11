package com.barras.colores;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Muestra un ejemplo del color que está siendo seleccionado
 */

public class VisualizadorColor extends JPanel implements ChangeListener {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getParent().getSize().width, 50);
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        ColorSelectionModel csm = (ColorSelectionModel) changeEvent.getSource();
        setBackground(csm.getSelectedColor());
    }
}
