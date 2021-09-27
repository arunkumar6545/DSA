import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllElementsThatAreinBSortedArray {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        System.out.println(repeatedNumber(a));
    }

    /*
    Intersection Of Sorted Arrays
Problem Description

Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example:

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 3 5]

Output: [3 3 5]

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 5]

Output: [3 5]
     */

    public static int repeatedNumber(final List<Integer> a) {
        int val = -1;
        int count = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0;i<a.size();i++){
            int k = 0;
            if(m.containsKey(a.get(i))){
                k = m.get(a.get(i)) + 1;

                m.put(a.get(i), k);
            }else {
                m.put(a.get(i), 1);
                k = 1;
            }
            if(k > count){
                count = k;
                val = a.get(i);
            }
        }

        return count > a.size()/3 ? val: -1;
    }
}
