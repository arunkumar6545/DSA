import java.util.Arrays;

public class FIndSubArrayifSortedwillSOrtWHoleArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}));
    }
    /*
    when can we say if an element to be a part of subarray to be sorted is if it is not in its right position
    so logic is see if elemtents are in their right position
    now just clone given array as B and sort B
    now compare and get start and end index of the elements which are not in their right positions
     */

    public static int solve(int[] A) {
        if(A.length < 2) return 0;
        int B[] = A.clone();

        Arrays.sort(B);
        int min = -1, max = -1;
        for(int i = 0;i<A.length;i++){
            if(A[i] != B[i]){
                if(min == -1){
                    min = i;
                }else{
                    max = i;
                }
            }
        }
        return min == -1? 0:max - min + 1;
    }
}
