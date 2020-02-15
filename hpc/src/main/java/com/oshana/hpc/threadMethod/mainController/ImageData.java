package com.oshana.hpc.threadMethod.mainController;

import java.awt.image.BufferedImage;

public class ImageData {
    private BufferedImage grayScaleImg;
    private BufferedImage binaryImg;
    private int[] grayPixelsArray;

    ImageData(BufferedImage grayScaleImg, BufferedImage binaryImg, int[] grayPixelsArray) {
        this.grayScaleImg = grayScaleImg;
        this.grayPixelsArray = grayPixelsArray;
        this.binaryImg = binaryImg;
    }

    BufferedImage getGrayScaleImg() {
        return grayScaleImg;
    }

    BufferedImage getBinaryImg() { return binaryImg; }

    int[] getGrayPixelsArray() {
        return grayPixelsArray;
    }

    public void setGrayScaleImg(BufferedImage grayScaleImg) {
        this.grayScaleImg = grayScaleImg;
    }

    public void setBinaryImg(BufferedImage binaryImg) { this.binaryImg = binaryImg; }

    public void setGrayPixelsArray(int[] grayPixelsArray) {
        this.grayPixelsArray = grayPixelsArray;
    }
}
