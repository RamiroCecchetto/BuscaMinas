package com.cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Cuadricula {

    JButton btn;
    BufferedImage imgBomba;
    Boolean mina;
    Integer num = 0;
    public Cuadricula() {
        btn = new JButton();
        btn.setPreferredSize(new Dimension(50, 50));

        imgBomba = Util.getImage("mina.png");
        mina = false;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boolean isMina() {
        return mina;
    }

    public void setMina() {
        btn.setBackground(Color.BLACK);
        mina = true;
    }
    public JButton getButton () {
        return btn;
    }

}
