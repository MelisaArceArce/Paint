package com;

import com.barras.colores.BarraColores;
import com.barras.herramientas.BarraHerramientas;

import javax.swing.*;
import java.awt.*;

public class Paint {
    private static void agregarComponentesPane(Container pane) {
        BarraColores barra = new BarraColores();
        BarraHerramientas barraHerr = new BarraHerramientas();
        Lienzo lienzo = new Lienzo();

        pane.add(barra, BorderLayout.LINE_START);
        pane.add(barraHerr, BorderLayout.LINE_END);
        pane.add(lienzo, BorderLayout.CENTER);
    }

    private static void crearGUI() {
        JFrame frame = new JFrame("com.Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        agregarComponentesPane(frame.getContentPane());

        frame.pack(); // Ajusta la ventana al tamaño preferido de sus componentes
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearGUI();
            }
        });
    }
}
