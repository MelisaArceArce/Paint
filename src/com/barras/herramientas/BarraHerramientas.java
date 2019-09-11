package com.barras.herramientas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Columna de herramientas disponibles
 */
public class BarraHerramientas extends JPanel {
    public static Herramienta herrActiva;
    private List<BotonHerramienta> herrBoton;
    private List<Herramienta> herramientas;

    public BarraHerramientas() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        herrBoton = new ArrayList<>(13);
        herramientas = new ArrayList<>(13);

        BotonHerramienta brushHerr = new BotonHerramienta("icons/edit.png");
        herrBoton.add(brushHerr);
        herramientas.add(new Pincel());
        add(brushHerr);

        herrActiva = herramientas.get(0);

        setVisible(true);
    }
}
