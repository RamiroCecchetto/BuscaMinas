package com.cecchetto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Util {
    public static double FRAME_RATE = 60.0;

    public static BufferedImage getImage (String path) {
        try {
            return ImageIO.read(Objects.requireNonNull(Util.class.getClassLoader().getResourceAsStream(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static float map(float value, float startl, float stopl, float start2, float stop2) {
        return start2 + (stop2 - start2) * ((value - startl) / (stopl - startl));
    }

    public static File getFile (String path) {
        try {
            return new File("src/main/resources/" + path);
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
