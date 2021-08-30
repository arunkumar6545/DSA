package com.arun.scaler.practice.array;

public class LeftRotateArray {
    public static void main(String[] args) {
        int a[] = rotateLeft(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3);
        for (int aa :
                a) {
            System.out.print(aa);
        }
    }
    /*
    input: 1,2,3,4,5,6,7
    rotate left: 3 postions
    output: 5,6,7,1,2,3,4

    logic : step 1 reverse whole array output 7,6,5,4,3,2,1
    step 2 reverse from 0 to shift - 1 positions output 5,6,7, 4,3,2,1
    step 3 reverse from shift to last ele output 5,6,7, 1,2,3,4

     */

    public static int[] rotateLeft(int[] a, int shift) {
        a = reverse(a, a.length, 0);
        a = reverse(a, shift, 0);
        a = reverse(a, a.length - shift, shift);
        return a;
    }

    public static int[] reverse(int[] a, int loopTill, int shift) {
        for (int k = 0, l = loopTill - 1; k < loopTill / 2; k++, l--) {
            int temp = a[k + shift];
            a[k + shift] = a[l + shift];
            a[l + shift] = temp;
        }

        return a;
    }
}
