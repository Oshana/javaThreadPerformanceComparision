////////////////////////////////|
// Author: Oshana Dissanayake //|
//    All Rights Reserved     //|
//      github/oshana         //|
////////////////////////////////|

package com.oshana.hpc.serialMethod.mainController;

import com.oshana.hpc.serialMethod.convertToBinaryImage.ConvertToBinaryImageController;
import com.oshana.hpc.serialMethod.basicThresholding.FindThresholdController;
import com.oshana.hpc.serialMethod.convertToGrayScale.ConvertToGrayScaleController;
import com.oshana.hpc.serialMethod.convertToGrayScale.ImageData;
import com.oshana.hpc.serialMethod.imageReadWrite.ImageReadWriteController;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainController {
    public void serialMain(String imageName) {
        long startTime = System.currentTimeMillis();
//        System.out.println("Main Thread is Starting...");
        ImageReadWriteController irw = new ImageReadWriteController();
        ConvertToGrayScaleController cg = new ConvertToGrayScaleController();
        FindThresholdController ftc = new FindThresholdController();
        ConvertToBinaryImageController tic = new ConvertToBinaryImageController();

        try {
//            System.out.println("Main Thread is Running...");

            //Read the image file
//            File originalImg = irw.ReadImage("hpc\\images\\32X32_1.jpg");
            File originalImg = irw.ReadImage("hpc\\images\\dataset\\" + imageName);

            //convert to gray scale image
            ImageData imageData = cg.ConvertToGrayScale(originalImg);
            BufferedImage grayScaleImage = imageData.getGrayScaleImg();

            //write the gray scale image
            irw.WriteGrayScaleImage(grayScaleImage);

            //find the threshold data
            int[] thresholdData = ftc.FindThreshold(imageData.getGrayPixelsArray());

            //create the binary image
            BufferedImage binaryImg = tic.ThresholdImage(grayScaleImage,thresholdData);

            //write the binary image
            irw.WriteBinaryImage(binaryImg);

        }catch (IOException e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
//        System.out.println("Main Thread is Stopping...");
        System.out.println("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
    }
}
