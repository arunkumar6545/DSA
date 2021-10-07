public class FindSumofORofAllsubarrays {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4,5}));
    }
    /*
    SUBARRAY OR
Problem Description

Given an array of integers A of size N.

Value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of Value of all subarrays of A % 109 + 7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108



Input Format
The first argument given is the integer array A.



Output Format
Return the sum of Value of all subarrays of A % 109 + 7.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [7, 8, 9, 10]


Example Output
Output 1:

 71
Output 2:

 110


Example Explanation
Explanation 1:

 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
Explanation 2:

 Sum of value of all subarray is 110.
===================================================
Intuition--

Similar to contribution problem we need to check a particular bits contribution in OR

example 1,2,3,4,5
we need to check contribution of 0,1,2 bit positions to final sum
which is if 0th position is 1 then its contribution is 1 *  math.pow(2,0);
if 1st position bit is 1 then its contribution is 1 *  Math.pow(2,1) and so on.

now we need to check how many such contributions are done by every subarray for the respective position like 0,1,2 bit postions

Lets process for given ex:
0th bit: A[0] = 1 its set and its obvious that A[0] exists in any subarray its 0th bits contribution is always there
A[0] exists in 5 subarrays and its contribution is 5 * Math.pow(2,0);
     */

    public static int solve(int[] A) {
        int resultSum = 0;

        for(int i = 0;i<31;i++){
            int totalzeros = 0;
            for(int j = 0;j<A.length;j++){
                //Keep counting zeros as it may not contribute to final OR but one of its subarray element can
                if((A[j] & 1) == 0){
                    totalzeros++;
                }
                //Since there is a 1 now A[i] and its subarray result in value
                //prev to this if there are any 0's then their subarrays with A[i] contribute to final value
                //so calculate as totalzeros + 1 which is current element * no of subarrays * contribution(Math.pow(2, bitpostion))
                else{
                    resultSum += (totalzeros + 1) * (A.length - j) * Math.pow(2,i);
                    totalzeros = 0;
                }
                A[j] = A[j] >> 1;
            }
        }

        return resultSum;
    }
}
