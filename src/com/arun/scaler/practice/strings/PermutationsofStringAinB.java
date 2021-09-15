import java.util.*;

public class PermutationsofStringAinB {
    public static void main(String[] args) {
        System.out.println(solve("abc","abcbacabc"));
    }
    /*
    Permutations of A in B
Problem Description

You are given two strings A and B of size N and M respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two argument, A and B of type String.



Output Format
Return a single Integer, i.e number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa
  =============================================================
  intution:
  find freq array of string A and String B until length of A;
  find if its anagram them count is 1 else 0
  loop till len(b) - len(a) +1
  at i-th position you dont need freq of [i-1] char and need to inc freq of [i + a.len -1] char
  again if anagram then inc count else continue;

  permutation is nothing but all anagrams possible
     */
    public static int solve(String A, String B) {
        int ana[] = new int[26];
        int bna[] = new int[26];

        for(int i = 0;i<A.length();i++){
            ana[A.charAt(i)-'a']++;
            bna[B.charAt(i)-'a']++;
        }
        int count = isAnagram(ana,bna)? 1: 0;
        //IN THIS LOOP EVERYITERATION INORDER TO FIND IF STRING ANAGRAM
        //REMOVE THE FIRST CHAR AND ADD NEXT AVAILABLE CHAR
        //EG: INITIALLY IN STRING ABCADEB   IF SEARCHING FOR STRING BCA
        /*
        LOOP 0: WE ARE HAVE FREQ ARRAY OF A AND FOR B TILL LENGTH OF A JUST CHECK IF THEY ARE ANAGRAM
        SO START BELOW LOOP FROM 1;
        LOOP 1: NOW DISCARD CHAR AT 0 AND INCLUDE CHAR AT 3 WHICH IS 1,2,3
                NOW JUST DECREMENT COUNT OF CHAR 0
                AND INCREMENT FOR COUNT OF CHAR 3

         LOOP 2: NOW DISCARD CHAR 1 AND INCLUDE CHAR AT 4 WHICH IS 2,3,4
                NOW JUST DECREMENT COUNT OF CHAR AT 1
                AND INCREMENT COUNT OF CHAR AT 4

                CONTINUE;
              */
        for(int i = 1;i<B.length() - A.length() + 1;i++){
            bna[B.charAt(i-1) - 'a']--;
            bna[B.charAt(i + A.length() -1) - 'a']++;
            if(isAnagram(ana,bna))
                count++;
        }

        return count;


    }

    public static boolean isAnagram(int ana[], int bna[]){
        for(int i = 0;i<ana.length;i++){
            if(ana[i] != bna[i])
                return false;
        }
        return true;
    }
}
