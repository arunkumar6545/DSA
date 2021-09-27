public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{-4,3} , new int[]{-2,-2}));
    }

    public static int[] solve(final int[] A, final int[] B) {
        int r[] = new int[A.length + B.length];
        int i = 0,j=0,c = 0;
        while(i < A.length && j < B.length){
            if(A[i] > B[j]){
                r[c] = B[j];j++;
            }else{
                r[c] = A[i];i++;
            }
            c++;
        }
        if(i != A.length){
            for(int k = i; k<A.length;k++ ){
                r[c] = A[k];
                c++;
            }

        }else if(j != B.length){
            for(int k = j;k<B.length;k++ ){
                r[c] = B[k];
                c++;
            }
        }

        return r;
    }
}
