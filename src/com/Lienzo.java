package com;

import com.barras.herramientas.BarraHerramientas;
import com.barras.herramientas.Herramienta;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * com.Lienzo donde se puede dibujar
 * Se encarga de ver los cambios al trazar con el mouse
 */
//@TODO Crear listeners para cambiar herrActiva
public class Lienzo extends JPanel {
    private Herramienta herrActiva;

    Lienzo() {
        herrActiva = BarraHerramientas.herrActiva;
        herrActiva.inicializar(this);

        setBackground(Color.white);

        addMouseListener(herrActiva.ma);
        addMouseMotionListener(herrActiva.ma);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        herrActiva.setGraphics(g2d);

        //g2d.setColor(com.barras.colores.BarraColores.botonActivo.getBackground());
        herrActiva.dibujar();

        g2d.dispose();
    }
}
