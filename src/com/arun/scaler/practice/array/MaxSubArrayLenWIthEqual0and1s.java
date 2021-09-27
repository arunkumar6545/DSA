import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayLenWIthEqual0and1s {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,1,1,0,1,1,0,0,1,1,1,1,1,1,1}));
    }

    public static int solve(int[] A) {
        /*
        convert all 0s to -1
        take prefix sum of array now
        if 0 is present then count is from index 0 to current index that is currentindex + 1;
        if not then check current prefix sum in index i is present in map
        if yes then take index of that sum in map - current index
        above statement means since values are equal for sure elements after current index to index in map has
        equal 1s and 0s
         */
        if(A.length < 2) return 0;
        A[0] = A[0] == 0 ? -1: 1;
        Map<Integer,Integer> m = new HashMap<>();
        int count = 0;
        for(int i = 1;i<A.length;i++){
            A[i] = A[i] == 0 ? -1: 1;
            A[i] += A[i-1];
            m.put(A[i], i);
        }
        for(int i = 0;i<A.length;i++){
                if(A[i] == 0){
                    count = Math.max(i+1,count);
                }else {
                    if(m.containsKey(A[i]) && m.get(A[i]) != i){
                        count = Math.max(count, m.get(A[i]) - i);
                    }
                }
        }

        return count;

    }
}
