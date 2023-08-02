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

        asignarCuadriculas();

    }


    int cantidadMinas;
    private void asignarCuadriculas() {
        if (dimension.height == 8) cantidadMinas = 10;
        if (dimension.height == 16) cantidadMinas = 40;
        if (dimension.height == 30) cantidadMinas = 99;

        Set<Point> puntosAleatorios = new HashSet<>();


        while (puntosAleatorios.size() < cantidadMinas) {

            puntosAleatorios.add(new Point(new Random().nextInt(dimension.width), new Random().nextInt(dimension.height)));

        }


    }


    public void jugar() {



    }

}
