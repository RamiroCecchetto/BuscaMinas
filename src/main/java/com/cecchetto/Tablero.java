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

    }

    final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    Boolean jugando = true;
    public void jugar() {

        while (jugando) {

            cuadraditos.forEach( obj -> {obj.forEach( obj1 -> {if (obj1.isTocada() && obj1.isMina()) perder();});});

            for (int x=0 ; x<dimension.width ; x++) {
                for (int y=0 ; y<dimension.height ; y++) {

                    if (cuadraditos.get(x).get(y).getNum() == 0 && cuadraditos.get(x).get(y).isTocada()) {
                        for (int i=0 ; i<8 ; i++) {
                            int x1 = x + dx[i];
                            int y1 = y + dy[i];
                            if (x1 >= 0 && x1 < dimension.width && y1 >= 0 && y1 < dimension.height)
                                if (cuadraditos.get(x1).get(y1).getNum() == 0)
                                    cuadraditos.get(x1).get(y1).action();
                        }
                    }

                }
            }

        }

        System.out.println("ganaste papu");

    }

    public void asignarNumeros() {

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
                    cuadraditos.get(x).get(y).setNum(cantidadMinas);
                }

            }
        }

    }

    int cantidadMinas;

    public void asugnasMinas() {
        if (dimension.height == 8) cantidadMinas = 10;
        if (dimension.height == 16) cantidadMinas = 40;
        if (dimension.height == 30) cantidadMinas = 99;

        Set<Point> puntosAleatorios = new HashSet<>();

        while (puntosAleatorios.size() < cantidadMinas)
            puntosAleatorios.add(new Point(new Random().nextInt(dimension.width), new Random().nextInt(dimension.height)));

        for (Point puntosAleatorio : puntosAleatorios)
            cuadraditos.get(puntosAleatorio.x).get(puntosAleatorio.y).setMina();
    }

    private void perder() {
        System.out.println("perdiste mi rey");
    }


}
