public class ReverseWholeStringByWOrds {

    public static void main(String arg[]){
        System.out.println(solve("this is "));
    }

    /*
    Intution:
    reverse whole string
    then reverse word by word
     */
    public static String solve(String A) {
        StringBuilder s = new StringBuilder(A);
        String res = s.reverse().toString();
        StringBuilder a = new StringBuilder();
        StringBuilder ABuilder = new StringBuilder();
        int i = res.charAt(0) == ' '? 1:0;
        for(; i<res.length(); i++){
            if(res.charAt(i) != ' ')
                a.append(res.charAt(i));
            else{
                a.reverse();
                ABuilder.append(a);
                if(i != res.length()-1)
                    ABuilder.append(' ');
                a = new StringBuilder();
            }
        }
        A = ABuilder.toString();

        if(a.length() > 0){
            A+=a.reverse().toString();
        }

        return A;


    }


}
