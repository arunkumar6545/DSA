
public class TotalNoofSubsequencesinaArray {
    public static void main(String[] args) {
        System.out.println(count());
    }

    //FInd subsequence containing a and g
    //first occurence should be a followed by g -> order maintained.
    /*
    Intuition
    Start from R to L
    if g occurs then increment gcounter.
    if a occurs then subsequence could have formed with g so add counter += gcounter.
    continue till the start of array.

     */

    public static int count(){
        char[] a= new char[]{'a','g','c','d','e','f','a','e','g','g'};
        /*
        here subsequences are a -> g index pairs (0,1),(0,8),(0,9), (6,8), (6,9)
        so total subsequences are 5
         */

        int count = 0;int gcounter = 0;
        for(int i = a.length-1;i>=0;i--){
            if(a[i] == 'g'){
                gcounter ++;
            }else if(a[i] == 'a'){
                count += gcounter;
            }
        }
        return count;
    }
}
