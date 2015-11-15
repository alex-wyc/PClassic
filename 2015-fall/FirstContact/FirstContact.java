import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FirstContact {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("FirstContactIN.txt"));

    while (br.ready()) {
      String[] input = br.readLine().split(" ");
      long numRows = Long.parseLong(input[0]);
      long divisor = Long.parseLong(input[1]);
      long modulus = Long.parseLong(input[2]);
      System.out.println(countDivisible(numRows, divisor, modulus));
    }
    br.close();
  }

  // Fill out the body of this method
  public static long countDivisible(
      long numRows, 
      long divisor,
      long modulus) {
      int size = (int)Math.ceil(Math.log(numRows)/Math.log(divisor));
      long[] brep = new long[size];
      long tempRows = numRows;
      for (int i=0; i < size; i++) {
	  brep[size - 1 - i] = tempRows%divisor;
	  tempRows = tempRows/divisor;
      }
      long tot = ((numRows*(numRows+1))/2) % modulus;
      long curTerm = 1;
      long prodBrep = 1;
      for (int i = 0; i < size; i++) {
	  prodBrep *= brep[i] + 1;
	  curTerm = expon(divisor*(divisor+1)/2, size-1-i)*prodBrep*brep[i]/2;
	  tot = (tot - curTerm)%modulus;
      }
      if (tot < 0) {
          tot+=modulus;
      }
    return tot;
  }

    public static long expon(long base, long exp) {
	if (exp == 0) {
	    return 1;
	}
	else {
	    return base * expon(base, exp - 1);
	}
    }

}
