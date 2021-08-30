package com.arun.scaler.practice.array;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    public static int[][] solve(int[][] A) {
        //Transpose and reverse is the logic
/*
You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will only receive partial score.



Problem Constraints
1 <= n <= 1000



Input Format
First argument is a 2D matrix A of integers



Output Format
Return the 2D rotated matrix.



Example Input
Input 1:

 [
    [1, 2],
    [3, 4]
 ]
Input 2:

 [
    [1]
 ]


Example Output
Output 1:

 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [1]
 ]


Example Explanation
Explanation 1:

 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1
Explanation 2:

 2D array remains the ssame as there is only element.
----------------------------------------------------------
1 2 3    7 4 1
4 5 6    8 5 2-----> out put after 90 deg rotation
7 8 9    3 6 9

Transpose - rows becomes columns and columns becomes rows
after transpose.
1 4 7
2 5 8
3 6 9
small observation here transpose is reverse elements in a row of output
so reverse every row in the transposed matrix
 */
        for(int i =0;i<A.length;i++){
            for(int j = i+1;j<A.length;j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        for(int i = 0;i<A.length;i++){
            for(int k = 0,j=A.length -1;k<A.length/2;k++,j--){
                int temp = A[i][k];
                A[i][k] = A[i][j];
                A[i][j] = temp;
            }
        }
return A;
    }


}

