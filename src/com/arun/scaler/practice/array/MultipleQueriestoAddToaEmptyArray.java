public class MultipleQueriestoAddToaEmptyArray {
    public static void main(String[] args) {
        System.out.println(solve(10, new int[][]{
                {1, 3, 10},
  {6, 9, 2},
  {3, 5, 3},
  {2, 8, 4},
  {6, 7, 5}
}));
    }

    /*  Hard
    Beggars Outside Temple
There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.

Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.

Example:

Input:
N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

Return: [10, 55, 45, 25, 25]

Explanation:
=> First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]

=> Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]

=> Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
no of beggars be 6
for the first input [0,2,10] 10rs is given to all beggars from 0th to 2nd
curr output would be iteration1: 10 10 10 0 0 0

intuition
step1
lets say if we want to create a prefix array of above output
initial array is all zero: 0 0 0 0 0 0
        since beggars from 0 to 2 is given 10rs
simplified array: just give first person at 0th index 10rs
    becomes lvl1: 10 0 0 0 0 0 - prefix array version of this would be 10 10 10 10 10 10
    but in first iteration output was 10 10 10 0 0 0
    so 4t0 6 is 0 so lvl1 could be rewritten as give 4th person -10
    now lvl1 - [10 0 0 -10 0 0 0]
    if we calculate prefix array o/p is [ 10,10,10,0,0,0] = iteration1;

   Logic here is defer initial prefix array calculation to last.

   now continue step1 for all other queries and if there is already a number > 0 in that position add "X" rupees
   to exising entry in res array.
   after all the queries are run

   final step is to calculate prefix logic on above res array.

     */

    public static int[] solve(int A, int[][] B) {
        int res[] = new int[A];

        for(int i = 0;i<B.length;i++){
            res[B[i][0] -1] += B[i][2];
            if(B[i][1] != res.length){
                res[B[i][1]] += -B[i][2];
            }
        }

        for(int i =1;i<res.length;i++){
            res[i] = res[i] + res[i-1];
        }

        return res;
    }
}
