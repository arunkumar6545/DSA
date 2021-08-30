package com.arun.scaler.practice.bits;

public class NumberOfSetBits {
    public static void main(String[] args) {
        System.out.println(numSetBits(31));
        System.out.println(numSetBitsShift(31));
    }
    public static int numSetBits(int A) {
        int count = 0;
        while(A != 0){
            if( A % 2 == 1)
                count ++;
            A = A/2;
        }

        return count;
    }

    public static int numSetBitsShift(int A) {
        int count = 0;
        while(A!=0){
            if((A & 1) == 1)
                count++;
            A = A >> 1;
        }

        return count;
    }
}
