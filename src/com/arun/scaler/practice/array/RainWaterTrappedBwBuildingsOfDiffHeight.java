
import java.util.*;



public class RainWaterTrappedBwBuildingsOfDiffHeight {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //Intuition
    /*
    Rain Water Trapped
Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.


==========================================================
intution:
Create two arrays kind of prefix arrays but diff logic
Eg:  0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
how Lstorage is constructed

for index 0  to 1 if rain falls there is not storage as water leaks
Means at every position get max of building heigths
from 0 to 1 max of buildings height is 1;
now find capacity of storage if max - height of current index i is 0 or < 0 then storage is 0 else max - height[i];
Lstorage is built

-- Follow the same for Rstorage form R to L direction with same max and capacity logic

final ans would be loop from 0 to n at every step calculate sum += Math.min(L[i], r[i]) woule be result.
     */

    public static int trap(final int[] A) {
        int Lstorage[] = new int[A.length];
        int Rstorage[] = new  int[A.length];
        int maxL = A[0];
        int maxR = A[A.length - 1];
        Lstorage[0] = 0;
        Rstorage[A.length -1] = 0;
        for(int i = 1, j = A.length-2;i< A.length;i++, j--){
            maxL = Math.max(maxL, A[i]);
            int capacity = maxL - A[i];
            Lstorage[i] = Math.max(0, capacity);
            maxR = Math.max(maxR, A[j]);
            capacity = maxR - A[j];
            Rstorage[j] = Math.max(0, capacity);
        }

        int sum = 0 ;

        for(int i = 0;i<A.length;i++){
            sum += Math.min(Lstorage[i],Rstorage[i]);
        }

        return sum;


    }
}
