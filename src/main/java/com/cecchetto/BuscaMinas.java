package com.cecchetto;

import javax.swing.*;
import java.awt.*;

public class BuscaMinas extends JFrame {

    Dimension dimension;
    public BuscaMinas() {
        dimension = elegirTamanio();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        Tablero tablero = new Tablero(dimension);
        this.add(tablero);
        tablero.jugar();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private Dimension elegirTamanio() {

        Dimension dimension = new Dimension();
        String[] aux = { "8x8", "16x16", "16x30" };
        int[] opcion = {JOptionPane.showOptionDialog(
                null,
                "Elegir un tama\u00F1o",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                aux,
                aux[0]
        )};

        if (opcion[0] == JOptionPane.CLOSED_OPTION) System.exit(0);
        if (opcion[0] == 0) { dimension =  new Dimension(8, 8); }
        if (opcion[0] == 1) { dimension = new Dimension(16, 16); }
        if (opcion[0] == 2) { dimension = new Dimension(16, 30); }

        return dimension;

    }

}
