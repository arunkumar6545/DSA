package com.arun.scaler.practice.bits;

public class EveryNumberIsTwiceExceptOneFindThat {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public static int singleNumber(final int[] A) {
            //A xor A = 0 && 0 xor A = A
            //in every iteration this removes duplicates and result is single number
            for(int i = 1;i<A.length;i++){
                A[0] = A[0] ^ A[i];
            }

            return A[0];
        }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 2, 3, 4, 3, 2, 4, 5}));
    }
}
