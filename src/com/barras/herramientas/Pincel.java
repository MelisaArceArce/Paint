package com.barras.herramientas;

import com.Lienzo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Herramienta pincel que permite dibujar a mano alzada.
 */
public class Pincel extends Herramienta {
    private List<List<Point>> puntos;

    public void setGraphics(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public void inicializar(Lienzo lienzo) {
        puntos = new ArrayList<>(1);

        ma = new MouseAdapter() {
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

                lienzo.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                caminoActual = null;
            }
        };
    }

    public void dibujar() {
        g2d.setStroke(trazo);
        for (List<Point> camino : puntos) { // Dibuja líneas entre los puntos
            Point desde = null;
            for (Point hasta : camino) {
                if (desde != null) {
                    g2d.drawLine(desde.x, desde.y, hasta.x, hasta.y);
                }
                desde = hasta;
            }
        }
    }
}
