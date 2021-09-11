public class LexocographicallyLargest {
    /*
    Lexicographically Largest
You are given a string S. You want to change it to the lexicographically largest possible string by changing some of its characters. But you can only use characters of the string T as a replacement for characters of S. Formally, find the lexicographically largest string you can form by replacing some(or none) of the characters of S by using only the characters of string T. Note: Each character of T can be used at the most once.

Constraints:

1.   1 <= Length of S and T <= 50
2.   All the alphabets of S and T are lower case (a - z)
Input: A string A containing S and T separated by "_" character. (See example below)

Output: Lexicographically largest string P that can be formed by changing some or (none) characters of S using the characters of T.

Example:

Input:

A : "abb_c"
This implies S is "abb" and T is "c".

Output:

P = "cbb"
============================================================================
Intuition:
First build frequency array of all the chars after underscore in input
since lexicographically larger is expected start from count[25] which is z
now check if count[i] is > 0 means it has some chars and can be used for exchange

now start from char[0] to [n]
if i th ele is < char calculated from postion of count[i] array then replace that
else move to next char until all of them are completed
     */
        public String getLargest(String A) {
            String[] T = A.split("_");
            char[] in = T[0].toCharArray();
            int[] count = new int[26];
            for(int i = 0;i<T[1].length();i++){
                count[(int)T[1].charAt(i) - 97]++;

            }
            int i = 25;
            int c = 0;
            while(i>0){
                if(count[i] > 0){
                    while(c < in.length && count[i] > 0){
                        if(in[c] < (char)(i+97)){
                            in[c] = (char)(i+97);
                            count[i]--;
                        }
                        c++;
                    }
                }

                i--;
            }

            return String.valueOf(in);
        }

}
