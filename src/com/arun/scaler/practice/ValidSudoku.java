public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(validSudoku(new String[]{
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"}));
    }

    /*
    CHECK IF ALL THE ROW ARE UNIQUE
    CHECK IF ALL THE COLUMNS ARE UNIQUE
    CHECK IF ALL THE 3*3 MATRICES ARE UNIQUE
     */
    public static int validSudoku(String[] A){
        boolean r[] = new boolean[9];


        for(int i = 0;i< 9;i++){
            for(int j = 0;j<9;j++){
                if(A[i].charAt(j) != '.'){
                    int a = (A[i].charAt(j) - '1');
                    if(r[a]) return 0;
                    r[a] = true;
                }
            }
            r = new boolean[9];

        }

        for(int i = 0;i< 9;i++){
            for(int j = 0;j<9;j++){
                if(A[j].charAt(i) != '.'){
                    int a = (A[j].charAt(i) - '1');
                    if(r[a]) return 0;
                    r[a] = true;
                }
            }
            r = new boolean[9];

        }

        for(int k = 0;k< 3;k++){
            for(int i = 0;i<3;i++){
                for(int j = 0;j< 3;j++){
                    int index = j + 3 * k;
                    if(A[i].charAt(index) != '.'){
                        int a = (A[i].charAt(index) - '1');
                        if(r[a]) return 0;
                        r[a] = true;
                    }
                }
            }
            r = new boolean[9];
        }

        for(int k = 0;k< 3;k++){
            for(int i = 0;i<3;i++){
                for(int j = 0;j< 3;j++){
                    int index = i + 3 * k;
                    if(A[j].charAt(index) != '.'){
                        int a = (A[j].charAt(index) - '1');
                        if(r[a]) return 0;
                        r[a] = true;
                    }
                }
            }
            r = new boolean[9];
        }



        return 1;

    }
}
