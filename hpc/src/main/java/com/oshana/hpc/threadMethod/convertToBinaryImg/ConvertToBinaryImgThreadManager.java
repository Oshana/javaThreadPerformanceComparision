package com.oshana.hpc.threadMethod.convertToBinaryImg;

import java.awt.image.BufferedImage;

public class ConvertToBinaryImgThreadManager {

    public void createThreads(int[] valuesForHeight, int[] valuesForWidth, BufferedImage grayScaleImg, int[] thresholdData,
                              int threadNo) throws InterruptedException {

        ConvertToBinaryImageController cbic = new ConvertToBinaryImageController();

        Thread[] t = new Thread[threadNo];
        final int[] threadCount = {0};

        for(int z = 0; z< valuesForHeight.length-1; z++){
            for(int y = 0; y<valuesForWidth.length-1; y++){
                int finalZ = z;
                int finalY = y;
                t[threadCount[0]] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        cbic.ThresholdImage(valuesForHeight[finalZ],valuesForHeight[finalZ +1],
                                valuesForWidth[finalY],valuesForWidth[finalY +1],grayScaleImg,thresholdData);
                    }
                });
                threadCount[0]++;
            }
        }

        for (int i = 0; i < threadNo; i++) {
//            System.out.println("Main Thread "+i+" for binary scale image is Starting...");
            t[i].start();
        }

        for (int i = 0; i < threadNo; i++) {
//            System.out.println("Main Thread "+i+" for binary image is Stopping...");
            t[i].join();
        }
    }
}
