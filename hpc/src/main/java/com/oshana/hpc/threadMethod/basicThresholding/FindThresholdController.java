package com.oshana.hpc.threadMethod.basicThresholding;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class FindThresholdController {

    public int[] FindThreshold(int[] pixelArray){


        boolean state = false;
        int[] thresholdData = new int[3];
        int lesserThanSumOfAllValues = 0;
        int greaterThanSumOfAllValues = 0;
        int newThresholdValue = 0;

        double sum = IntStream.of(pixelArray).sum();
        int oldThresholdValue = (int) Math.rint(sum/pixelArray.length);

        while (!state){
            ArrayList<Integer> lessThan = new ArrayList<>();
            ArrayList<Integer> greaterThan = new ArrayList<>();

            for (int value : pixelArray) {
                if (value <= oldThresholdValue) {
                    lessThan.add(value);
                } else {
                    greaterThan.add(value);
                }
            }

            for (int value: lessThan) {
                lesserThanSumOfAllValues += value;
            }

            for (int value: greaterThan) {
                greaterThanSumOfAllValues += value;
            }

            int lesserThanAverageValue = (int) Math.rint((double)lesserThanSumOfAllValues/lessThan.size());
            int greaterThanAverageValue = (int) Math.rint((double)greaterThanSumOfAllValues/greaterThan.size());

            newThresholdValue = (int) Math.rint(((double)lesserThanAverageValue+greaterThanAverageValue)/2);

            state = Math.abs(oldThresholdValue - newThresholdValue) < 0.01;

            oldThresholdValue = newThresholdValue;
            lesserThanSumOfAllValues = 0;
            greaterThanSumOfAllValues = 0;

            thresholdData[0] = newThresholdValue;
            thresholdData[1] = lesserThanAverageValue;
            thresholdData[2] = greaterThanAverageValue;

        }
        return thresholdData;
    }
}
