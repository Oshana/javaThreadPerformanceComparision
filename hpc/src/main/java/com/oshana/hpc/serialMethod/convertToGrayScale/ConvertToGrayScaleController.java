package com.oshana.hpc.serialMethod.convertToGrayScale;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertToGrayScaleController {

    public ImageData ConvertToGrayScale(File originalImage){

        BufferedImage img = null;

        try {
            img = ImageIO.read(originalImage);

            BufferedImage grayScaleImage = new BufferedImage(img.getWidth(),img.getHeight(), BufferedImage.TYPE_INT_ARGB);

            int[] grayScalesArray = new int[img.getWidth()*img.getHeight()];
            int count = 0;

            for (int i = 0; i < img.getHeight(); i++) {
                for (int j = 0; j < img.getWidth() ; j++) {
                    Color c = new Color(img.getRGB(j,i));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    int a = c.getAlpha();

                    //Simple grayScaling = (r+g+b)/3
                    int gr = (r+g+b)/3;

                    grayScalesArray[count] = gr;
                    count++;

                    Color gColor = new Color(gr,gr,gr,a);
                    grayScaleImage.setRGB(j,i,gColor.getRGB());
                }
            }

            return new ImageData(grayScaleImage,grayScalesArray);

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
