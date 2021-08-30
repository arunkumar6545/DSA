package com.arun.scaler.practice.bits;

public class CountNoOfSetBitsFrom1toN {
    public static void main(String[] args) {
        System.out.println(solve(10));
    }
    public static  int solve(int A) {

        long a=  totalCount(A);
        return (int)a;
    }

    /*
    for this problem start from 0 to N rather than 1 to N.
    Form binary for all the elements from 0 to N.

    Eg: 15

    0 0 0 0 - 0
    0 0 0 1 - 1
    0 0 1 0 - 2
    0 0 1 1 - 3
    0 1 0 0 - 4
    0 1 0 1 - 5
    0 1 1 0 - 6
    0 1 1 1 - 7

    if we care fully observe from R to L at every bit postion there is a pattern
    1 position - every two rows has 1 bit
    2 postion - every 4 rows has 2 bits
    3 postion - every 8 rows has 4 bits and so on. Using this we build below formula

    since we are calc for int loop from 0 to 30 as 31 for +ve number so ignore it.
    small catch int +ve range is 2 pow 31 -1 so in line 40 we hold things in long.
     */

    public static long totalCount(int a1){
        long count = 0;
        for(int i=0;i<=30;i++){
            long a = 1 << (i+1);
            long b = 1 << i;
            count += (a1 +1)/a * b + Math.max((a1+1)%a - b, 0);
        }

        return  count % 1000000007;
    }


}

