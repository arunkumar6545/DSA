public class FindSmallestDiffbwmaxandminin3SortedArrays {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 4, 5, 8, 10}, new int[]{ 6, 9, 15 }, new int[]{2, 3, 6, 6}));
    }

    /*
    Minimize the absolute difference
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
     */

    /*
    A         -4 -1 3 5 7 8 9 10
    B         -1  2 4 6 9
    C         -10 -2 0 1 6 8 9

    1st pair A[0],B[0],c[0]  max(ofthem) - min(ofthem) = -1 - -10 = -1 + 10 = 9;
    since i want minum diff always and values are in sorted
    i can just have 3 pointers in i, j, k in A,B and C .

    for the first eg: if want to have min diff even if move A to 1 since value of A[i] is increasin diff will increase
    similary i can put A in 0 and B to 1 diff will increase as C[0] is the lowest
    so in all the indexes which ever has the minimum use that index and increment
    in first example 0 0 0 since c[0] has the min value and inorder to decrease diff i can move to nex value in C
    so that i may decrease the diff further and repeat same logic for all
     */
    public static int solve(int[] A, int[] B, int[] C) {
        int i = 0,j = 0,k = 0; int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minDIff = Integer.MAX_VALUE;
        while(i < A.length && j < B.length && k < C.length){
            min = Math.min(A[i],min);
            min = Math.min(B[j],min);
            min = Math.min(C[k], min);
            max = Math.max(A[i],max);
            max = Math.max(B[j],max);
            max = Math.max(C[k], max);

            if(A[i] == min) i++;
            else if( B[j] == min) j++;
            else {
                k++;
            }
            minDIff = Math.min(max - min, minDIff);
            min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
        }

        return minDIff;
    }
}
