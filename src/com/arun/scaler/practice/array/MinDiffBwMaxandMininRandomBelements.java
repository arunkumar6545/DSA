import java.util.Arrays;

public class MinDiffBwMaxandMininRandomBelements {
    public static void main(String[] args) {
        solve(new int[]{10, 12, 10, 7, 5, 22}, 4);
    }

    public static int solve(int[] A, int B) {
        //since you need diff of max and min in B elements to be minimum
        //its alwasys possible if elements are closest and diff is small
        //sorting array would help bring in order for small diff

        Arrays.sort(A);
        int min = A[0],max = A[B-1];
        int minDiff = max - min;
        for(int  i = B;i<A.length;i++){
            if(A[i] - A[i-B +1] < minDiff){
                minDiff = A[i] - A[i-B +1];
            }
        }
        return minDiff;
    }
}
