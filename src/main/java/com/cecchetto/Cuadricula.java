package com.cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Cuadricula {

    JButton btn;
    BufferedImage imgBomba;
    public Cuadricula() {
        btn = new JButton();
        btn.setPreferredSize(new Dimension(50, 50));

        imgBomba = Util.getImage("mina.png");
    }

    public JButton getButton () {
        return btn;
    }

}
