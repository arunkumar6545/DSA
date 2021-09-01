package com.ca.wcc.editor.server.util;

public class MinSubarrayContainingMinAndMaxValue {
    public static void main(String[] args) {
        int [] a = new int[]{3,8,1,1,4,5,1,6,8,2,2,2,1,2};
        System.out.println(counter(a));
    }
    /*
    Intuition
    1. subarray should contain both min and max.
    2. both are at corners.

    psuedo code
    1. start from R to L.
    2. when min occurs store the index and get the count between max and min index if maxindex already exists in right.
    3. when max occurs store the index and get the count between min and max index if minindex already exists in right.
     */

    public static int counter(int a[]){
        int minValue = 1, maxValue = 8;
        int count = Integer.MAX_VALUE;
        if(minValue == maxValue){
            return 1;
        }
        int minIndex = -1,maxIndex = -1;

        for(int i = a.length-1; i>=0;i--){
            if(a[i] == maxValue){
                maxIndex = i;
                if(minIndex !=-1){
                    count = Math.min(minIndex - maxIndex + 1, count);
                }
            }else if(a[i] == minValue){
                minIndex = i;
                if(maxIndex != -1){
                    count = Math.min(maxIndex - minIndex + 1, count);
                }
            }
        }

        return count;
    }
}
