import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta paleta de color predeterminada es una columna de botones con
 * los colores mas comunes
 */
class BarraColores extends JPanel {
    private Color colorActivo;
    private List<Color> colores;

    BarraColores() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        colores = new ArrayList<>(13);
        colores.add(Color.WHITE);
        colores.add(Color.BLACK);
        colores.add(Color.GRAY);
        colores.add(Color.LIGHT_GRAY);
        colores.add(Color.DARK_GRAY);
        colores.add(Color.RED);
        colores.add(Color.ORANGE);
        colores.add(Color.YELLOW);
        colores.add(Color.GREEN);
        colores.add(Color.BLUE);
        colores.add(Color.CYAN);
        colores.add(Color.PINK);
        colores.add(Color.MAGENTA);

        for (Color color : colores) {
            add(new BotonColor(color, this));
        }
    }

    void setColorActivo(Color color) {
        colorActivo = color;
    }
}
