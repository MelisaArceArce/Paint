import javax.swing.*;
import java.awt.*;

public class Paint {
    public static void agregarComponentesPane(Container pane) {
        Pincel pincel = new Pincel();
        BarraColores barra = new BarraColores();
        Lienzo lienzo = new Lienzo(pincel);
        ControlColor control = new ControlColor();
        control.setBarraColores(barra);
        control.setPincel(pincel);
        pane.add(barra, BorderLayout.LINE_START);
        pane.add(lienzo, BorderLayout.CENTER);
    }

    private static void crearGUI() {
        JFrame frame = new JFrame("Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarComponentesPane(frame.getContentPane());

        frame.pack(); // Ajusta la ventana al tamaño preferido de sus componentes
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearGUI();
            }
        });
    }
}
