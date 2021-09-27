public class RemoveOneElementinArrayWhereoddpostionssumisequaltoeven {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,1,1}));
    }

    /*
    create prefix array of sum of odd and even elements
    i.e A[2] has sum of 2 and 0 positions
    similarly for A[3] is a sum of 3 and 1 positions
    this is becuase we need to check sum of odd and even positions

    now if we remove an element
    if postion to be removed is
    even:
       then sums on the left of that postion are intact
       on right since element is to be removed is at even it should be minus from right lastEven postion sum
    odd: do reverse

    generally if an element is removed then right side odd becomes even elements and even become odd.

    so if element to be removed is at even position then check if
    even: for postion i to be removed
            if A[i-1] + onRightofI {A[lastEven] - A[i] - A[i-2]} == A[i-2] + {A[lastOdd) - A[i-1]}
            if closestLoddsum + totalevensum - currpostionval - closestLevensum
                                            ==  closestLevensum + totaloddsum - closestLOddsum

    odd: postion tobe removed do opposite of above.
    checkbelow for more
            if(even){
                if((ol + (A[lastEven] - val -el)) == ( el + (A[lastOdd] - ol)) )
                    count ++;
            }else{
                if((el + (A[lastOdd] - val -ol)) == ( ol + (A[lastEven] - el)) )
                    count ++;
            }

     */

    public static int solve(int[] A) {
        int count = 0;
        if (A.length < 3) return count;

        for(int i = 2;i<A.length;i++){
            A[i] += A[i-2];
        }
        int lastEven = A.length -1;
        int lastOdd = A.length -2;
        if(A.length % 2 == 0){
            lastEven = A.length -2;
            lastOdd = A.length -1;
        } boolean even = true; int el,ol,er,or,val;
        for(int i = 0;i<A.length;i++){
            if(even){
                el = i - 2 < 0 ? 0: A[i-2];
                ol = i - 1 < 0 ? 0: A[i -1];

            }else{
                ol = i - 2 < 0 ? 0: A[i-2];
                el = i - 1 < 0 ? 0: A[i -1];
            }
            val = i - 2 < 0 ? A[i]: A[i]-A[i-2];


            if(even){
                if((ol + (A[lastEven] - val -el)) == ( el + (A[lastOdd] - ol)) )
                    count ++;
            }else{
                if((el + (A[lastOdd] - val -ol)) == ( ol + (A[lastEven] - el)) )
                    count ++;
            }


            even = !even;
        }

        return count;

    }
}
