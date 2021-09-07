public class SubArrayWithSum0{
    
    
    /*

Sub-array with 0 sum
Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.



-----------------------------------------------------------

Intuition
      Find sum of all prefixes
      Arr :           1 2 3 -5 -1 2 4 -2 -1 -3 6
      prefix-sum:     1 3 6  1  0 2 6  4  3  0 6
      
      prefix sum is nothing but for i find sum of all elements from 0 - i
      
      Add all elements to hashset 
      Observations:
      1. if hashset contains 0 then there is a subarray with sum 0
      2. or if there are repetitive sum then hashset size is less than size arr length then also there exist subarray with sum 0
      
      Constraints overflow for int so store things in long.
      
      
     */
    
    
    public int solve(int[] A) {
        long sum = 0;
        Set<Long> s = new HashSet<>();
        for(int i = 0;i<A.length;i++){
            sum += A[i];
            s.add(sum);
        }
        
        if(s.contains(0L) || s.size() < A.length){
            return 1;
        }
        
        return 0;
        
    }
}
