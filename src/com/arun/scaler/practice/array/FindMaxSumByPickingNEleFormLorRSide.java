public class FindMaxSumByPickingNEleFormLorRSide {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{5, -2, 3 , 1, 2}, 3 ));
    }

    /*
    Pick from both sides!
Problem Description

Given an integer array A of size N.

You can pick B elements from either left or right end of the array A to get maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get

 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

 Intution:

 first find sum of B elements from LtoR that is 0 to B -1 elements and that becomes max and create sumL too.

 But user can choose from right side too and that could give us max

 now in another loop come from backwards and if we need to add one elemtent on right we have remove A[B-1] from sum

 now keep tracking sum from right too as sumR

 at every step if we need to include right element remove/substract one element from sumL and add rightElement to sumR.

 logic to remove element from sumL should be from elements at B-1, B-2, B-3 .........

at every step calculate max(suml+ sumr, max);
return max;

     */
    public static int solve(int[] A, int B) {
        int max = 0;
        for(int i = 0;i<B;i++){
            max += A[i];
        }

        if(B == A.length) return max;
        int sumL = max;
        int sumR = 0;
        for(int i = A.length -1, j = B -1;j>=0;j--, i--){
            sumR += A[i];
            sumL = sumL - A[j];
            max = Math.max(sumL + sumR,max);

        }
        return max;
    }
}
