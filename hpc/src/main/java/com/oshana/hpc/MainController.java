////////////////////////////////|
// Author: Oshana Dissanayake //|
//    All Rights Reserved     //|
//      github/oshana         //|
////////////////////////////////|

package com.oshana.hpc;

import com.oshana.hpc.threadMethod.imageReadWrite.ImageReadWriteController;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainController {

//    public static void main(String[] args) throws IOException {
//        ImageReadWriteController irw = new ImageReadWriteController();
//
//        //Initialize the Serial Method
//        com.oshana.hpc.serialMethod.mainController.MainController serialMain = new com.oshana.hpc.serialMethod.mainController.MainController();
//
//        //Initialize the Thread Method
//        com.oshana.hpc.threadMethod.mainController.MainController threadMain = new com.oshana.hpc.threadMethod.mainController.MainController();
//
//        //Set the input File name
//        String imageName = "320x240.jpg";
////        String imageName = "1600x1200.jpg";
////        String imageName = "2560x1440.jpg";
//
//        //Run the program
//        System.out.println("Image: "+imageName);
//        System.out.println("Serial Method");
//        serialMain.serialMain(imageName);
//        System.out.println("Thread Method");
//        threadMain.threadMain(imageName);
//
//        //Get the written image names
//        File threadImage = irw.ReadImage("hpc\\images\\binaryImage\\"
//                + imageName+"_binary_ThreadImage.png");
//        File serialImage = irw.ReadImage("hpc\\images\\binaryImage\\"
//                +imageName+"_binary_SerialImage.png");
//
//        //Read the images
//        BufferedImage threadImg = ImageIO.read(threadImage);
//        BufferedImage serialImg = ImageIO.read(serialImage);
//
//        //to measure the number of different pixels
//        int pixelCounter = 0;
//
//        //Iterate through the pixels in the images
//        for (int i = 0; i < threadImg.getHeight(); i++) {
//            for (int j = 0; j < threadImg.getWidth() ; j++) {
//
//                //get the pixel value in the serial image
//                Color c = new Color(serialImg.getRGB(j,i));
//                int r = c.getRed();
//                int g = c.getGreen();
//                int b = c.getBlue();
//                int a = c.getAlpha();
//
//                //Simple grayScaling = (r+g+b)/3
//                int serial = (r+g+b)/3;
//
//                //get the pixel value in the thread image
//                Color d = new Color(threadImg.getRGB(j,i));
//                int rd = d.getRed();
//                int gd = d.getGreen();
//                int bd = d.getBlue();
//                int ad = d.getAlpha();
//
//                //Simple grayScaling = (r+g+b)/3
//                int thread = (rd+gd+bd)/3;
//
//                //calculate the difference between the two pixel values
//                int result = Math.abs(serial-thread);
//
//                if(result != 0){
//                    pixelCounter++;
//                }
//            }
//        }
//
//        //calculate the accuracy
//        double accuracy = (1-((double)(pixelCounter)/(threadImg.getHeight()*threadImg.getWidth())))*100;
//
//        System.out.println("Accuracy: "+accuracy+" %");
//        System.out.println("----------------------------------");
//    }

    public static void main(String[] args) {

//        int[] numbers = {1,5,3,2,4};
//
//        boolean sort = false;
//        int temp;
//
//        while (!sort){
//            sort = true;
//            for (int i =0;i<numbers.length-1;i++){
//                if(numbers[i]>numbers[i+1]){
//                    temp = numbers[i];
//                    numbers[i] = numbers[i+1];
//                    numbers[i+1] = temp;
//                    sort = false;
//                }
//            }
//        }
//
//        for (int i: numbers
//             ) {
//            System.out.print(i+",");
//        }
//

        for(int i = 0;i<20;i++){
            if(i%2 != 0){
                if(i != 3){
                    if(i%3 != 0){
                        if( i != 5){
                            if(i%5 != 0){
                                System.out.println(i+",");
                            }
                        }else {
                            System.out.println(i+",");
                        }
                    }
                }else {
                    System.out.println(i+",");
                }

            }

        }
    }
}
