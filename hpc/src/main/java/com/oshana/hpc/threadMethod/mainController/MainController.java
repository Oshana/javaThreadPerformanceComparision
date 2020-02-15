////////////////////////////////|
// Author: Oshana Dissanayake //|
//    All Rights Reserved     //|
//      github/oshana         //|
////////////////////////////////|
package com.oshana.hpc.threadMethod.mainController;

import com.oshana.hpc.threadMethod.convertToBinaryImg.ConvertToBinaryImgThreadManager;
import com.oshana.hpc.threadMethod.basicThresholding.FindThresholdController;
import com.oshana.hpc.threadMethod.convertToGrayScale.ConvertToGrayScaleThreadManager;
import com.oshana.hpc.threadMethod.imageReadWrite.ImageReadWriteController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainController {
    public void threadMain(String imageName) {
        long startTime = System.currentTimeMillis();

        ImageReadWriteController irw = new ImageReadWriteController();
        FindThresholdController ftc = new FindThresholdController();
        BoundaryInformationGenerator big = new BoundaryInformationGenerator();
        ConvertToGrayScaleThreadManager convertToGrayScaleThreadManager = new ConvertToGrayScaleThreadManager();
        ConvertToBinaryImgThreadManager convertToBinaryImgThreadManager = new ConvertToBinaryImgThreadManager();

        //Initialize the variables
        //////////////////////////////////
        //   -------------------------  //
        //   |   1   |   2   |   3   |  //
        //   -------------------------  //
        //   |   4   |   5   |   6   |  //
        //   -------------------------  //
        //   |   7   |   8   |   9   |  //
        //   -------------------------  //
        //////////////////////////////////

        int threadNo = 9;
        int heightDivideFactor = 3;
        int widthDivideFactor = 3;

        try {
//            File originalImg = irw.ReadImage("hpc\\images\\32X32_1.jpg");
            File originalImg = irw.ReadImage("hpc\\images\\dataset\\"+imageName);
            BufferedImage img = ImageIO.read(originalImg);
            int width = img.getWidth();
            int height = img.getHeight();

            ParallelController parallelController = new ParallelController(width,height);

            //Generate the boundary data
            int[][] boundaryInformation = big.generateBoundaries(height,width,heightDivideFactor,widthDivideFactor);
            int[] valuesForHeight = boundaryInformation[0];
            int[] valuesForWidth = boundaryInformation[1];

            //Creating the Gray Scale Image using threads
            convertToGrayScaleThreadManager.createThreads(valuesForHeight,valuesForWidth,threadNo,img);

            //Write the Gray Scale Image
            BufferedImage grayScaleImg = parallelController.CreateImageData().getGrayScaleImg();
            irw.WriteGrayScaleImage(grayScaleImg);

            //Find the Threshold Data
            int[] thresholdData = ftc.FindThreshold(parallelController.CreateImageData().getGrayPixelsArray());

            //Creating the binary image using threads
            convertToBinaryImgThreadManager.createThreads(valuesForHeight,valuesForWidth, grayScaleImg,
                    thresholdData, threadNo);

            //Write the binary image
            irw.WriteBinaryImage(parallelController.CreateImageData().getBinaryImg());

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
    }
}
