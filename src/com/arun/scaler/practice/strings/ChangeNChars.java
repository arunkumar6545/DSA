public class ChangeNChars {
    public static void main(String[] args) {
        solve("abcabbccd", 3);
    }

    /*

    Change character
Problem Description

Given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N



Input Format
First argument is a string A.

Second argument is an integer B.



Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3



Example Output
2



Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
----------------------------------------------------------------------------------------
intuition:

find frequency array of all the chars from a ->z
now inorder to remove B chars from input to have min char string
keep substracting least freq from B and finally count no of nonzero count chars from a -> z freq array and return;
     */

    public static int solve(String A, int B) {
        int count[] = new int[26];
        int sum = 0;
        for(int i = 0;i<A.length();i++){
            count[(int)A.charAt(i) - 97]++;
        }

        while(B>0){
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for(int i = 0;i<26;i++){
                if(count[i] != 0){
                    if(min > count[i]){
                        min_index = i;
                        min = count[i];
                    }
                }
            }

            if(B - min < 0)
                break;
            else{
                B = B-min;
                count[min_index] = 0;
            }

        }

        for(int i=0;i<26;i++){
            if(count[i] > 0)
                sum++;
        }

        return sum;
    }
}
