package com.oshana.hpc.threadMethod.convertToGrayScale;

import com.oshana.hpc.threadMethod.mainController.ParallelController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ConvertToGrayScaleController{

    public void ConvertToGrayScale(int startHeight, int endHeight, int startWidth, int endWidth,BufferedImage img)
            throws IOException, InterruptedException {

        for (int i = startHeight; i < endHeight; i++) {
            for (int j = startWidth; j <endWidth; j++) {
                Color c = new Color(img.getRGB(j,i));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();

                //Simple grayScaling = (r+g+b)/3
                int gr = (r+g+b)/3;

                ParallelController.CreateGrayScaleArray(gr);

                Color gColor = new Color(gr,gr,gr,a);
                try {
                    ParallelController.CreateGrayScaleImage(j,i,gColor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
