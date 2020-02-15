package com.oshana.hpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class HpcApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HpcApplication.class, args);
	}

//	public static void main (String[] args) throws java.lang.Exception
//	{
//		int[] h = new int[]{0,34,68,100};
//		int[] w = new int[]{0,50,100,150};
//		int count = 0;
//		for(int z = 0; z< 3; z++){
//			for(int y = 0; y<3; y++){
//				System.out.println(count+": "+h[z]+","+h[z+1]+","+w[y]+","+w[y+1]);
//				count++;
//			}
//		}
//	}

//	public static void main(String[] args) {
//
//		int heightDivideFactor =3;
//		int widthDivideFactor = 3;
//		int height = 100;
//		int width = 150;
//
//
//		int[] valuesForHeight = new int[heightDivideFactor+1];
//		int[] valuesForWidth = new int[widthDivideFactor+1];
//		int count = 0;
//		int endHere = 0;
//		int heightFactor = (int)Math.ceil((double)height/heightDivideFactor);
//		int widthFactor = (int)Math.ceil((double)width/widthDivideFactor);
//
//		System.out.println("widthFactor: "+widthFactor);
//
//		for(int i=0; i<height;i = i+heightFactor){
//			valuesForHeight[count] = i;
//			endHere = Math.min(i + heightFactor, height);
//			if(endHere == height){
//				count++;
//				valuesForHeight[count] = height;
//			}
//			count++;
//		}
//
//		count = 0;
//
//		for(int i=0; i<width;i = i+widthFactor){
//			valuesForWidth[count] = i;
//			endHere = Math.min(i + widthFactor, width);
//			if(endHere == width){
//				count++;
//				valuesForWidth[count] = width;
//			}
//			count++;
//		}
//
//		for (int i: valuesForHeight
//			 ) {
//			System.out.print(i+",");
//
//		}
//		System.out.println();
//		for (int j: valuesForWidth
//			 ) {
//			System.out.print(j+",");
//		}
//	}
}
