package com.ca.uejm.access;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfAllNumsInArrayExceptItself {
    public static void main(String[] args) {
        System.out.println(solution1(new int[]{4,2,1,3,5}));
        System.out.println(solution2(new int[]{4,2,1,3,5}));
    }

    /*
    Solution 1:
    Find product of all numbers in one loop
    since we need to skip itself from product
    put it as  arr[i] = totalproduct / arr[i];


    solution 2;
    take new array and calculate product of elements from 0 to itself -1

    eg:   index 0  1  2  3  4
           arr  4  1  3  3  5
Leftarr product 1  4  4  12 36

how is above calculated for 0th since no element on left it becomes 1
for position 1 calculate product till position 1 minus 1 is at postion 0;
position 2 calculate product from 0 to 1 which is at position 1;
position i product of all left nums is in postion i -1;

for getting right product have a variable right product and keep multiplying to it from
r to l and multiply it with current position and you get solution.
     */
    public static int[] solution1(int[] A) {
        int product  = 1;
        for(int i = 0;i<A.length;i++){
            product *= A[i];
        }

        for (int i = 0;i<A.length;i++){
            A[i] = product / A[i];
        }
        return A;
    }

    public static int[] solution2(int[] A) {
       int product = A[A.length -1];

       int pro =A[0];
               A[0] = 1;
       for(int i = 1;i<A.length;i++){
           int curr = A[i];
           A[i] = pro;
           pro = pro * curr;
       }
       int prevLeftProduct = A[A.length -1];
       for(int i = A.length -2;i>=0;i--){
           int curr = prevLeftProduct/A[i];
           prevLeftProduct = A[i];
           A[i] = A[i] * product;
           product = product * curr;

       }
       return A;
    }

}
