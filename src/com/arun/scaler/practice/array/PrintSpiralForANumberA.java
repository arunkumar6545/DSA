public class PrintSpiralForANumberA {
    public static void main(String[] args) {
        generateMatrix(9);
    }

        public static int[][] generateMatrix(int A) {
        if(A == 1) return new int[][]{new int[]{1}};
            int B[][] = new int[A][A];
            int count = 0;
            int pow = 0;int center = 0;
            int i =0,j =0;
            while(center <= (A/2 == 0 ? A/2 -1 : A/2)){
                while(j < A - center - 1){
                    count++;
                    B[i][j] = count;
                    j++;

                }
                while(i < A -center - 1){
                    count++;
                    B[i][j] = count;
                    i++;
                }

                while(j >= center + 1){
                    count++;
                    B[i][j] = count;
                    j--;
                }


                while(i >= center + 1){
                    count++;
                    B[i][j] = count;
                    i--;
                }




                center++;
                i = j =center;
            }

            if(center %2 == 1){
                B[i-1][j-1] = count + 1;
            }

            return B;


        }



}
