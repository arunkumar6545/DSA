package com.arun.scaler.practice.array;

/*
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.


Problem Constraints
1<= N <= 1000
1<= A[i][j] <= 1e9


Input Format
First argument is an integer N, denoting the size of square 2D matrix.
Second argument is a 2D array A of size N * N.


Output Format
Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.


Example Input
Input 1:
3
1 2 3
4 5 6
7 8 9
Input 2:

1 2
3 4


Example Output
Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
Output 2:

1 0
2 3
4 0
 */
public class AntiDiagonal {
    public static void main(String[] args) {
        diagonal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public static int[][] diagonal(int[][] A) {
        int[][] B = new int[2 * A.length -1][A.length];

        int center = 0;
        int acenter = A.length -1;

        while(acenter >= 0){
            int r = center;

            for(int i=0;i<=acenter;i++){
                B[r++][center] = A[center][i];

            }
            for(int i = center + 1;i<A.length;i++){
                B[r++][center] = A[i][acenter];

            }

            acenter--;
            center++;




        }

        return B;
    }
}
