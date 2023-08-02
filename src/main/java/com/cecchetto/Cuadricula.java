package com.cecchetto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Cuadricula {

    JButton btn;
    BufferedImage imgBomba;
    Boolean mina, tocada = false;
    Integer num = 0;
    public Cuadricula() {
        btn = new JButton();
        btn.setPreferredSize(new Dimension(50, 50));
        btn.setBackground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(Color.RED));

        imgBomba = Util.getImage("mina.png");
        mina = false;
        btn.addActionListener( e -> action() );
    }

    public void action() {

        tocada = true;
        btn.setEnabled(false);

        if (mina)
            btn.setBackground(Color.BLACK);
        else
            btn.setText(Integer.toString(num));

    }

    public Boolean isTocada() {
        return tocada;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public Boolean isMina() {
        return mina;
    }

    public void setMina() {
        mina = true;
    }

    public JButton getButton () {
        return btn;
    }

}
