public class FindXORofGivenQueries {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{ 1, 0, 0, 0, 1},
                new int[][]{{2,4}, {1, 5}, {3,5}}));
    }
    /*
    Xor queries
Problem Description

You are given an array A (containing only 0 and 1) as element of N length.
Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.



Problem Constraints
1<=N,Q<=100000
1<=L<=R<=N


Input Format
First argument contains the array of size N containing 0 and 1 only.
Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.


Output Format
Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.


Example Input
A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]


Example Output
[[0 3]
[0 3]
[1 2]]


Example Explanation
In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1.
For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3.
Similarly for other queries.
===================================
Intuition:

Just follow sum of subarray by using prefix sum
calculate prefix xor of array
and for query [1,5] then remove A[0] xor from A[5] xor
just like if we want to have sum from 1 to 5 we need to substract A[5] - A[0] which is sum(A[2,3,4,5]);

     */
    public static int[][] solve(int[] A, int[][] B) {
        int zeros[] = new int[A.length];
        if(A[0] == 0) zeros[0] = 1;
        for(int i = 1;i<A.length;i++){
            if(A[i] == 0){
                zeros[i] = zeros[i-1] + 1;
            }else zeros[i] = zeros[i-1];
            A[i] = A[i] ^ A[i-1];

        }

        for(int i = 0;i<B.length;i++){
            int l = B[i][0] -1;
            int r = B[i][1] -1;
            B[i][0] = l -1 >= 0 ?A[l -1] ^ A[r]: A[r];
            B[i][1] = zeros[r] - (l-1 < 0? 0: zeros[l-1]);
        }
        return B;
    }
}
