import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo que aparece al dar doble clic a un BotonColor
 */
class SelectorColor extends JColorChooser {
    private ColorListener colorListener = new ColorListener();
    Color color = null;

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            color = getColor();
        }
    }

    SelectorColor() {
        VisualizadorColor vc = new VisualizadorColor();
        setPreviewPanel(vc);

        getSelectionModel().addChangeListener(vc);
    }

    /**
     * Muestra el diálogo para seleccionar color
     */
    void creaDialogo() {
        color = null;
        JDialog dialogo = JColorChooser.createDialog(
            this.getParent(),
            "Elige color",
            true, // Hace que no pueda seguir siendo usada la aplicación
            this,
            colorListener,
            null);
        dialogo.setVisible(true);
    }
}
