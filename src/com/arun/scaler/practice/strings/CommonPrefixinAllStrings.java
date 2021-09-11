public class CommonPrefixinAllStrings {

    public static void main(String arg[]){
        System.out.println(longestCommonPrefix(new String[]{"abc","abcd", "de"}));
    }

    /*
    Intution:
    Initially it becomes A[0]
    Keep finding common prefix for every two strings.
     */
    public  static String longestCommonPrefix(String[] A) {
        String com = A[0];

        for(int i = 1;i<A.length ;i++){
            com = comm(com, A[i]);
            if(com.length() == 0) break;
        }

        return com;
    }

    public static String comm(String comm, String a){
        StringBuilder c = new StringBuilder();
        for(int i = 0;i < comm.length();i++){
            if(i < a.length() && comm.charAt(i) == a.charAt(i)){
                c.append(comm.charAt(i));
            }else break;
        }
        return c.toString();

    }



}
