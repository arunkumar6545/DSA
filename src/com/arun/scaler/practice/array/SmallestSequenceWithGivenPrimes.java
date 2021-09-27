public class SmallestSequenceWithGivenPrimes {

    public static int[] solve(int A, int B, int C, int D) {
        int input[] = new int[]{A,B,C};
        int res[] = new int[D];
        int val = 0;
        if(D == 1) return new int[]{A};
        else if(D == 2) return new int[]{A,B};
        else if(D == 3) return new int[]{A,B,C};
        D = D - 3; int i = 2;
        while(D > 2){
            D--; i++;
            if(val == 0) {
                res[i] = A * res[i - 3];
            }else if(val == 1){
                res[i] = B * res[i-3];
            }else{
                res[i] = C * res[i-3];
            }
            if(i % 3 == 2) val++;

            val = val % 3;
        }

        return res;

    }
}
