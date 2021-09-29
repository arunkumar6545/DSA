public class COnstructArrayUsingTwoofItsnumbersHavingDIffAtConsecutiveElements {

    public static void main(String[] args) {
        System.out.println(solve(7, 39, 41));
    }

    /*

    Construct Array
Problem Description

Simba has an integer array of length A. Despite having insisted alot, He is not ready to reveal the array to his friend Expert. But now, he is ready to reveal some hints about the array and challenges Expert to find the values of his hidden array. The hints revealed are as follows:

The array is sorted by values in ascending order.
All the elements in the array are distinct and positive (greater than 0).
The array contains two elements B and C such that B < C.
Difference between all adjacent (consecutive) elements are equal.
Among all the arrays satisfying the above conditions, his array has the minimum possible maximum element value.
If there are multiple possible arrays, his array will have minimum possible minimum element value.
Can you help Expert to construct such an array and surprise Simba?



Problem Constraints
2 <= A <= 50

1 <= B < C <= 50



Input Format
First argument is an integer A.

Second argument is an integer B.

Third argument is an integer C.



Output Format
Return a sorted integer array having length N, denoting Simba's Secret Array.



Example Input
Input 1:

 A = 5
 B = 20
 C = 50
Input 2:

 A = 2
 B = 2
 C = 3


Example Output
Output 1:

 [10, 20, 30, 40, 50]
Output 2:

 [2, 3]


Example Explanation
Explanation 1:

 Sorted array = [10, 20, 30, 40, 50] satisfies all the conditions having maximum value = 50 minimum possible.
 Other arrays such as [20, 30, 40, 50, 60] having max value = 60 or [20, 50, 80, 120] having max value = 120, also satisfy conditions but their maximum value is not minimum possible(As minimum possible max value is 50).
Explanation 2:

 As the array has only 2 elements, [2, 3] is the only possible candidate.


 ================================================================================

 intuition:

 this is a arithmetic progression problem
 a    a + d   a + 2d       a + 3d .... a+nd
 in such series of size n only two values are given and we need to construct array with missing values
 Two B and C can exist any where in the array
 so to construct array of n = 5 values B and C could exist at

 1,2  1,3  1,4  1,5
 2,3  2,4  2,5
 3,4  3,5
 4,5

 lets say if elements exist at postion 2, 4 then as AP

 formula would be a + d = B and a + 3d = C
                C - B = a + 3d - (a + d)
                C - B = 3d -d = 2d
                d = (C - B) /2
                replace d in any of two equation a + 3d = C and we get a

             some conditions to be satisfied
             1. a should always be > 0
             2. diff should always be integer
             3. if two serries has same last element then series with lowest first element to be considered in final array
     */

    public static int[] solve(final int A, final int B, final int C) {
        int minDiff = Integer.MAX_VALUE,  first = 0;
        for(int i = 0;i<A-1;i++){
            for(int j = i + 1;j < A;j++){
                if((B-C) % (j-i) == 0){
                    int d = (C-B)/(j-i);
                    int a = C-j*d;

                    if(a<=0) continue;

                    if((a + (A-1)*d) == (first + (A-1)*minDiff)){
                        first = a;
                        minDiff = d;
                    }
                    else if(minDiff > d){
                        first = a;
                        minDiff = d;
                    }else if(minDiff == d && first > a){
                        first = a;
                    }

                }
            }
        }

        int res[] = new int[A];
        for(int i = 0;i<A;i++){
            res[i] = first + i * minDiff;
        }

        return res;
    }
}
