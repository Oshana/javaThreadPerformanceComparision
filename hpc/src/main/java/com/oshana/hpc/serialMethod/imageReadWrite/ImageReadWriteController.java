package com.oshana.hpc.serialMethod.imageReadWrite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReadWriteController
{
    private String fileName;

    public File ReadImage(String filePath)throws IOException
    {
        File originalImage = new File(filePath);
        fileName = originalImage.getName();
        return originalImage;
    }

    public void WriteGrayScaleImage(BufferedImage grayScaleImage) throws IOException
    {
        ImageIO.write(grayScaleImage,"png",new File("hpc\\images\\grayScales\\"
                +fileName.substring(0,fileName.length()-4)
                +"_grayScale_SerialImage.png"));
    }

    public void WriteBinaryImage(BufferedImage binaryImage) throws IOException
    {
        ImageIO.write(binaryImage,"png",new File("hpc\\images\\binaryImage\\"
                +fileName+"_binary_SerialImage.png"));
    }
}