package com.oshana.hpc.threadMethod.convertToGrayScale;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Component
public class ConvertToGrayScaleThreadManager {

    public void createThreads(int[] valuesForHeight, int[] valuesForWidth, int threadNo, BufferedImage img)
            throws InterruptedException {

        ConvertToGrayScaleController cg = new ConvertToGrayScaleController();

        //Thread Function
        Thread[] t = new Thread[threadNo];

        final int[] threadCount = {0};

        for(int z = 0; z< valuesForHeight.length-1; z++){
            for(int y = 0; y<valuesForWidth.length-1; y++){
                int finalZ = z;
                int finalY = y;
                t[threadCount[0]] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            cg.ConvertToGrayScale(valuesForHeight[finalZ],valuesForHeight[finalZ +1],
                                    valuesForWidth[finalY],valuesForWidth[finalY +1],img);
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threadCount[0]++;
            }
        }

        for (int i = 0; i < threadNo; i++) {
//            System.out.println("Main Thread "+i+" for gray scale image is Starting...");
            t[i].start();
        }

        for (int i = 0; i < threadNo; i++) {
//            System.out.println("Main Thread "+i+" for gray scale image is Stopping...");
            t[i].join();
        }
    }
}
