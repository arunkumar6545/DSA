public class FindMaxSizeofConsecutive1sIfaSwapOf1And0allowed {
    public static void main(String[] args) {
        System.out.println(count("11100111011110111"));
    }
    /*
    Intuition:
    1. at a index what is the count of consecutive 1s on left and right?

    eg:     1  1   1   0   1  1  0  0  1  1  1  1  0  1  1  1
    create two arrays with cumulative sum of 1s from left and 1 for right
    increment counter as long as something is 1 else make it zero
    index   0  1   2   3   4  5  6  7  8  9  10 11 12 13 14 15
            1  1   1   0   1  1  0  0  1  1  1  1  0  1  1  1
    LtoR:   1  2   3   0   1  2  0  0  1  2  3  4  0  1  2  3  -> Arr1
    RtoL:   3  2   1   0   2  1  0  0  4  3  2  1  0  3  2  1  -> Arr2

    Now for any index i if a[i] is 1 then no of consecutive 1's from its left and right is found from above formed arrays Arr1
    and Arr2

      eg:  index 10 - Arr1[10-1] + Arr2[10+1] + 1
           index i - Arr1[i-1] + Arr2[i+1] + 1

    Applying the same logic if at position i is 0 then since one swap is allowed apply above formula on this one too
     -> position i has '0' and max consecutive '1's possible after swap would be
              if      Arr1[i-1] + Arr2[i+1] + 1 -> this happens only if there are excess more 1's available for swap
            else    Arr1[i-1] + Arr2[i+1] -> since no extra 1 is available swap exist 1 itself
                    Eg: for else case 1 1 1 0 1 1 1 -> since no extra 1 just swap(0,3) and count woule be 6
             How to know if there is extra 1 available for swap is
             -> in one loop find count of all 1's available
             now in 'if' Arr1[i-1]+ Arr2[i+1] < count means extra one is available else no.

     */

    public static int count(String a) {

        int lcounts[] = new int[a.length()];
        int rcounts[] = new int[a.length()];
        int allOnes = 0;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') {
                allOnes++;
                count++;
            } else {
                count = 0;
            }


            lcounts[i] = count;
        }

        if(a.length() == 0 || a.length() == 1 || a.length() == 2){
            return count;
        }

        count = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                count++;
            } else {
                count = 0;
            }

            rcounts[i] = count;
        }

        int maxCount = 0;
        for(int i = 1;i<a.length()-1;i++){
            if(a.charAt(i) == '1'){
                maxCount = Math.max(maxCount, lcounts[i-1] + rcounts[i+1]+ 1);
            }else{
                if(lcounts[i-1] + rcounts[i+1] < allOnes){
                    maxCount = Math.max(maxCount, lcounts[i-1] + rcounts[i+1]+ 1);
                } else
                    maxCount = Math.max(maxCount, lcounts[i-1] + rcounts[i+1]);
            }
        }

        return maxCount;
    }
}
