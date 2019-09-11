package com.barras.herramientas;

import com.Lienzo;

import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * com.barras.herramientas.Herramienta que se encuentra en la barra de herramientas
 */
public abstract class Herramienta {
    Graphics2D g2d;
    private float ancho = 1f;
    Stroke trazo = new BasicStroke(ancho, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    public MouseAdapter ma = null;

    public abstract void setGraphics(Graphics2D g2d);

    /**
     * Inicializa los valores necesarios para la herramienta
     * Se inicializa aquí el MouseAdapter si es que hay
     * @param lienzo donde se va a dibujar
     */
    public abstract void inicializar(Lienzo lienzo);

    /**
     * Uso de métodos del objeto g2d
     */
    public abstract void dibujar();
}
