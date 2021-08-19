package com.arun.scaler.practice.array;

public class ShiftArrayRight{
    public static void main(String[] args) {
	// write your code here
        int a[] = new int[]{1,2,3,4,5};
        int d = 3;
        int currv = a[0];
        int curri = 0;
        int count = 0;
        while(count < a.length){
            int temp = currv;
            int shift = curri + d >= a.length ? curri + d -a.length : curri + d;
            currv  = a[shift];
            a[shift] = temp;
            curri = shift;
            count++;
        }
        for (int i : a) {
            System.out.println(i);
        }
    }
}
