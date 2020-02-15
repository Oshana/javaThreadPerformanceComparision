package com.oshana.hpc.threadMethod.mainController;

public class BoundaryInformationGenerator {
    public int[][] generateBoundaries(int height, int width,int heightDivideFactor, int widthDivideFactor){
        int[][] boundaryInfo = new int[2][];
        int[] valuesForHeight = new int[heightDivideFactor+1];
        int[] valuesForWidth = new int[widthDivideFactor+1];
        int count = 0;
        int endHere = 0;
        int heightFactor = (int)Math.ceil((double)height/heightDivideFactor);
        int widthFactor = (int)Math.ceil((double)width/widthDivideFactor);

        for(int i=0; i<height;i = i+heightFactor){
            valuesForHeight[count] = i;
            endHere = Math.min(i + heightFactor, height);
            if(endHere == height){
                count++;
                valuesForHeight[count] = height;
            }
            count++;
        }

        count = 0;

        for(int i=0; i<width;i = i+widthFactor){
            valuesForWidth[count] = i;
            endHere = Math.min(i + widthFactor, width);
            if(endHere == width){
                count++;
                valuesForWidth[count] = width;
            }
            count++;
        }

        boundaryInfo[0] = valuesForHeight;
        boundaryInfo[1] = valuesForWidth;

        return boundaryInfo;
    }
}
