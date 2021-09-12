import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimiseDiffBWMaxMinWithBincordecOperations {
    public static void main(String[] args) {
        System.out.println( solve(new int[]{ 2, 8, 3, 7, 8, 7, 9 }, 9));
    }
    /*
    Minimize Difference
Problem Description

Given an array of integers A of size, N. Minimize the absolute difference between the maximum and minimum element of the array.

You can perform two types of operations at most B times in total to change the values in the array.
Multiple operations can be performed on the same element.

Increment : A[i] -> A[i] + 1.

Decrement : A[i] -> A[i] - 1.

Return the minimum difference possible.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 106

1 <= B <= 109



Input Format
First argument is an integer array A.
Second argument is an integer B which represents the maximum number of operations that can be performed.



Output Format
Return an integer denoting the minimum difference.



Example Input
Input 1:

 A = [2, 6, 3, 9, 8]
 B = 3
Input 2:

 A = [4, 6, 3, 1, 4]
 B = 5


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 We can apply the atmost 3 operations in the following sequence.
 Initial array => [2, 6, 3, 9, 8].
   Decrement 9 => [2, 6, 3, 8, 8].
   Increment 2 => [3, 6, 3, 8, 8].
   Increment 3 => [3, 6, 4, 8, 8].
 Max = 8. Min = 3.
 Therefore, abs|Max - Min| = |8 - 3| = 5.
Explanation 2:

 We can apply the atmost 5 operations in the following sequence.
 Initial array => [4, 6, 3, 1, 4].
   Increment 1 => [4, 6, 3, 2, 4].
   Decrement 6 => [4, 5, 3, 2, 4].
   Increment 2 => [4, 5, 3, 3, 4].
   Decrement 5 => [4, 4, 3, 3, 4].
   Increment 3 => [4, 4, 4, 3, 4].
 Max = 4. Min = 3.
 Therefore, abs|Max - Min| = |4 - 3| = 1.
     */


    public static int solve(int[] A, int B) {
       Map<Integer,Integer> map = new HashMap<>();
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       for(int i = 0;i<A.length;i++){
           //find min
           min = Math.min(A[i], min);
           //find max
           max = Math.max(A[i], max);
           //find freq of all the numbers
           if(map.containsKey(A[i])){
               map.put(A[i], map.get((A[i]))+1);
           }else map.put(A[i], 1);
       }
       /*
        At evert step find number with less freq bw min and max
        if freq min < then dec so many inc operations from B
        and now inc all the min values and now a new min is formed if new min already present then inc it with curr inc count done

        other way do it for max.
        */
       while(min < max && B > 0){
           if(B == 0) break;

           if(map.get(min) >= map.get(max)){
               if(B - map.get(max) < 0) break;
               int cm = map.get(max);
               B = B - cm;
               max--;
               if(map.containsKey(max)){
                   map.put(max, map.get(max) + cm);
               }else map.put(max, cm);

           }else{
               if(B - map.get(min) < 0) break;
               int cm = map.get(min);
               B = B - cm;
               min++;
               if(map.containsKey(min)){
                   map.put(min, map.get(min) + cm);
               }else map.put(min, cm);
           }
       }

       return max -min;
    }

}
