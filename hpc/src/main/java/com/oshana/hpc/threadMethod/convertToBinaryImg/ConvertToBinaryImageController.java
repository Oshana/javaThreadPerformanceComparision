package com.oshana.hpc.threadMethod.convertToBinaryImg;

import com.oshana.hpc.threadMethod.mainController.ParallelController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ConvertToBinaryImageController {

    public void ThresholdImage(int startHeight, int endHeight, int startWidth, int endWidth,BufferedImage img,
                               int[] thresholdData){
        try {
//            BufferedImage img = ImageIO.read(grayScaleImage);
            WritableRaster wr = img.getRaster() ;

//            System.out.println("Start height: "+startHeight+"----"+"end height: "+endHeight);
//            System.out.println("Start width: "+startWidth+"----"+"end width: "+endWidth);

            for (int i = startHeight; i < endHeight; i++) {
                for (int j = startWidth; j < endWidth ; j++) {
                    int p = wr.getSample(j,i,0);
                    int a = (p>>24) & 0xff;

                    if(p > thresholdData[0]){
//                        p = thresholdData[2];
                        p = 255;
                    }else {
//                        p = thresholdData[1];
                        p = 0;
                    }

                    Color bColor = new Color(p,p,p);

                    ParallelController.CreateBinaryImage(j,i,bColor);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
