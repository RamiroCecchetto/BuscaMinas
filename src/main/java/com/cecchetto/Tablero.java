package com.cecchetto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Tablero extends JPanel{


    Dimension dimension;
    ArrayList<ArrayList<Cuadricula>> cuadraditos;
    public Tablero(Dimension dimension) {
        this.dimension = dimension;

        this.setLayout(new GridLayout(dimension.width, dimension.height));

        cuadraditos = new ArrayList<>();
        for (int x=0 ; x<dimension.width ; x++)
            cuadraditos.add(new ArrayList<>());

        for (int x=0 ; x<dimension.width ; x++)
            for (int y=0 ; y<dimension.height ; y++)
                cuadraditos.get(x).add(new Cuadricula());

        for (ArrayList<Cuadricula> filas : cuadraditos) {
            for (Cuadricula columnas : filas) {
                this.add(columnas.getButton());
            }
        }

        asugnasMinas();
        asignarNumeros();

    }

    private void asignarNumeros() {

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {

                if (!cuadraditos.get(x).get(y).isMina()) {
                    int cantidadMinas = 0;
                    for (int i = 0; i < 8; i++) {
                        int x1 = x + dx[i];
                        int y1 = y + dy[i];

                        if (x1 >= 0 && x1 < dimension.width && y1 >= 0 && y1 < dimension.height)
                            if (cuadraditos.get(x1).get(y1).isMina())
                                cantidadMinas++;

                    }
                    cuadraditos.get(x).get(y).getButton().setText(Integer.toString(cantidadMinas));
                }

            }
        }

//        for (int x=0 ; x<dimension.width ; x++) {
//            for (int y=0 ; y<dimension.height ; y++) {
//
//                if (!cuadraditos.get(x).get(y).isMina()) {
//                    int num = 0;
//                    for (int x1=x-1 ; x1<x)
//                }
//
//            }
//        }

    }


    int cantidadMinas;
    private void asugnasMinas() {
        if (dimension.height == 8) cantidadMinas = 10;
        if (dimension.height == 16) cantidadMinas = 40;
        if (dimension.height == 30) cantidadMinas = 99;

        Set<Point> puntosAleatorios = new HashSet<>();

        while (puntosAleatorios.size() < cantidadMinas)
            puntosAleatorios.add(new Point(new Random().nextInt(dimension.width), new Random().nextInt(dimension.height)));

        for (Point puntosAleatorio : puntosAleatorios)
            cuadraditos.get(puntosAleatorio.x).get(puntosAleatorio.y).setMina();
    }


    public void jugar() {



    }

}
