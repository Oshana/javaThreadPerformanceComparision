package com.oshana.hpc.serialMethod.convertToGrayScale;

import java.awt.image.BufferedImage;

public class ImageData {
    private BufferedImage grayScaleImg;
    private int[] grayPixelsArray;

    public ImageData(BufferedImage grayScaleImg, int[] grayPixelsArray) {
        this.grayScaleImg = grayScaleImg;
        this.grayPixelsArray = grayPixelsArray;
    }

    public BufferedImage getGrayScaleImg() {
        return grayScaleImg;
    }

    public int[] getGrayPixelsArray() {
        return grayPixelsArray;
    }

    public void setGrayScaleImg(BufferedImage grayScaleImg) {
        this.grayScaleImg = grayScaleImg;
    }

    public void setGrayPixelsArray(int[] grayPixelsArray) {
        this.grayPixelsArray = grayPixelsArray;
    }
}
