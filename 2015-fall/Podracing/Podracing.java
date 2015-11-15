import java.util.*;
import java.io.*;

class Podracing
{
    static int N;
    static int[] A;
    static long sumHalf;

    public static void main(String[] args)throws IOException
    {
        Scanner in = new Scanner(new FileReader("PodracingIN.txt"));
        int T =  in.nextInt();
        while(T-- >0){
            int N = in.nextInt();
            int A[] = new int[N];
            for(int i = 0 ; i < N ; i++)
                A[i] = in.nextInt();
            EqualSums(N, A);
        }
    }

    static void EqualSums(int NS, int[] AS)
    {
        N = NS;
        if (N < 30) {
            A = AS;
            sumHalf = 0;
            for (int i = 0; i < N; i++) {
                sumHalf += A[i];
            }
            if (sumHalf % 2 == 1) {
                System.out.println(false);
            }
            else {
                Arrays.sort(A);
                sumHalf /= 2;
                System.out.println(divide(N - 1, 0));
            }
        }
        else {
            System.out.println(true);
        }
    }

    static boolean divide(int pos, long sum) {
        if (sum > sumHalf) {
            return false;
        }
        if (sum == sumHalf) {
            return true;
        }
        return divide(pos - 1, sum + A[pos]) || divide(pos - 1, sum);
    }
}
