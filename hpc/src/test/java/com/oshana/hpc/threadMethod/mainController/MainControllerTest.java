package com.oshana.hpc.threadMethod.mainController;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    @Test
    void main() {

        int num = 10/4;




        for(int i=0; i<=10;i = i+num+1){
            System.out.println("start - " + i);
            if(i+num >= 10){
                System.out.println(10);
            }else{
                System.out.println("end - " + (i+num));
            }

        }
    }
}