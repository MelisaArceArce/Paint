import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Herramienta que se encuentra en la barra de herramientas
 */
abstract class Herramienta {
    Graphics2D g2d;
    private float ancho = 1f;
    Stroke trazo = new BasicStroke(ancho, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    MouseAdapter ma = null;

    abstract void setGraphics(Graphics2D g2d);

    /**
     * Inicializa los valores necesarios para la herramienta
     * Se inicializa aquí el MouseAdapter si es que hay
     * @param lienzo donde se va a dibujar
     */
    abstract void inicializar(Lienzo lienzo);

    /**
     * Uso de métodos del objeto g2d
     */
    abstract void dibujar();
}
