import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo que aparece al dar doble clic a un BotonColor
 */
public class SelectorColor extends JColorChooser implements ActionListener {
    private BotonColor botonPadre;

    SelectorColor() {
        VisualizadorColor vc = new VisualizadorColor();
        setPreviewPanel(vc);

        getSelectionModel().addChangeListener(vc);
    }

    void creaDialogo(BotonColor bn) {
        botonPadre = bn;
        JDialog dialogo = JColorChooser.createDialog(
                bn,
                "Elige color",
                true, // Hace que no pueda seguir siendo usada la aplicación
                this,
                this,
                null);
        dialogo.setLocationRelativeTo(getParent());
        dialogo.setVisible(true);
    }

    /**
     * Cambia de color el botón al dar clic en "Aceptar"
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        botonPadre.setBackground(getColor());
    }
}
