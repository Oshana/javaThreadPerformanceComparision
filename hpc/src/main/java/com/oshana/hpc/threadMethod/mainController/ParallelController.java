package com.oshana.hpc.threadMethod.mainController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ParallelController {

    private static int index=0;
    private static int[] grayScalesArray;
    private static BufferedImage grayScaleImage;
    private static BufferedImage binaryImage;

    ParallelController(int width, int height) throws IOException {
        grayScalesArray = new int[width * height];
        grayScaleImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        binaryImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
    }

    public static synchronized void CreateGrayScaleImage(int j, int i, Color gColor) throws IOException {
        grayScaleImage.setRGB(j,i,gColor.getRGB());
    }

    public static synchronized void CreateBinaryImage(int j, int i, Color bColor) throws IOException {
        binaryImage.setRGB(j,i,bColor.getRGB());
    }

    public static synchronized void CreateGrayScaleArray(int value){
        grayScalesArray[index] = value;
        index++;
    }

    public int[] getGrayScalesArray() {
        return grayScalesArray;
    }

    ImageData CreateImageData(){
        return new ImageData(grayScaleImage,binaryImage,grayScalesArray);
    }
}
