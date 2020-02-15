package com.oshana.hpc.serialMethod.convertToBinaryImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ConvertToBinaryImageController {

    public BufferedImage ThresholdImage(BufferedImage img, int[] thresholdData){
        WritableRaster wr = img.getRaster() ;

        BufferedImage binaryImage = new BufferedImage(img.getWidth(),img.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth() ; j++) {
                int p = wr.getSample(j,i,0);
//                    int a = (p>>24) & 0xff;

                if(p > thresholdData[0]){
//                        p = thresholdData[2];
                    p = 255;
                }else {
//                        p = thresholdData[1];
                    p = 0;
                }

                Color bColor = new Color(p,p,p);
                binaryImage.setRGB(j,i,bColor.getRGB());
            }
        }
        return binaryImage;
    }
}
