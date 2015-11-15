import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SafeSpacewalks {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("SafeSpacewalksIN.txt"));
        while (fileInput.hasNext()) {
            int sum = fileInput.nextInt();
            int k = fileInput.nextInt();
            ArrayList<Integer> tools = new ArrayList<Integer>();
            for (int i = 0; i < k; i++) {
                tools.add(fileInput.nextInt());
            }
            int numValidQuadruples = fourSum(sum, tools);
            System.out.println(numValidQuadruples);
        }
    }

    // Fill out the body of this method
    public static int fourSum(int sum, ArrayList<Integer> tools) {
        boolean[] test = new boolean[sum];
        for (Integer i : tools) {
            if (i < sum) {
                test[i] = true;
            }
        }
        int c = 0;
        int[] arr = new int[tools.size()];
        for (int i = 0 ; i < sum ; i++) {
            if (test[i]) {
                arr[c] = i;
                c++;
            }
        }

        int d = 0;
        for (int i = 0 ; i < c && arr[i] <= sum / 4 ; i++) {
            for (int j = i + 1 ; j < c && arr[j] <= sum / 3 ; j++) {
                for (int k = j + 1 ; k < c && arr[k] <= sum / 2 ; k++) {
                    if ((sum - arr[i] - arr[j] - arr[k]) > arr[k] && test[sum - arr[i] - arr[j] - arr[k]]) {
                        d++;
                    }
                }
            }
        }
        return d;
    }
}
