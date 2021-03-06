import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.File;
import java.math.BigInteger;

public class RocketBoxes {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(
				"RocketBoxesIN.txt"));

		while (br.ready()) {
            int a = ways(Integer.parseInt(br.readLine()));
            System.out.println(a);
		}
		br.close();
	}
	public static int ways(int size) {
	    int x = oneCounter(size);
	    BigInteger two = new BigInteger("2");
	    BigInteger three = new BigInteger("3");
        int a = two.pow(x).intValue();
        int partI = (three.pow(a).intValue() + 1) / 2;
        int partII = (three.pow(size - a).intValue());
        return partI * partII;
	}

	public static int oneCounter(int n) {
        int m = n - 1;
        int c = 0;
        while (m > 0) {
            if (m % 2 == 1) {
                c++;
            }
            m = m / 2;
        }

        return c;
    }
}
