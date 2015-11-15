import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StarTemperatures {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("StarTemperaturesIN.txt"));

        while (br.ready()) {
            int numStars = Integer.parseInt(br.readLine());
            int[] temperatures = new int[numStars];
            String[] strTemperatures = br.readLine().split(" ");
            for (int i = 0; i < numStars; i++) {
                temperatures[i] = Integer.parseInt(strTemperatures[i]);
            }
            medianTemperatures(temperatures);
        }
        br.close();
    }

    // Fill out the body of this method
    public static void medianTemperatures(int[] temperatures) {
        int[] bukcets = new int[10000];
        for (int i = 0 ; i < temperatures.length ; i++) {
            bukcets[temperatures[i]]++;
            int c = 0;
            for (int j = 0 ; j < 10000 ; j++) {
                c+=bukcets[j];
                if (c >= i / 2 - (i % 2) + 1) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
