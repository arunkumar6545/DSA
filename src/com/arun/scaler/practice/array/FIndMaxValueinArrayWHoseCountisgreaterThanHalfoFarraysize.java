import java.util.HashMap;
import java.util.Map;

public class FIndMaxValueinArrayWHoseCountisgreaterThanHalfoFarraysize {
    public static void main(String[] args) {
        System.out.println();
    }

    public int majorityElement(final int[] A) {
        int maxIndex = A[0];
        int maxCount = 1;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i<A.length;i++){
            if(m.containsKey(A[i])){
                int count = m.get(A[i]) + 1;
                if(count > maxCount){
                    maxIndex = A[i];
                    maxCount = count;
                }
            }else{ m.put(A[i],1);
            }
        }

        return maxIndex;
    }
}
