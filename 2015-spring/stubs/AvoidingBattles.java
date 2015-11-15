import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AvoidingBattles {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("AvoidingBattlesIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int m = Integer.parseInt(data[0]);
      int n = Integer.parseInt(data[1]);
      char[][] map = new char[m][n];
      for (int i = 0; i < m; i++) {
        map[i] = br.readLine().toCharArray();
      }
      System.out.println(canAvoidBattles(m, n, map));
    }
    br.close();
  }

  // Fill out the body of this method
  public static boolean canAvoidBattles(int m, int n, char[][] map) {
    return false;
  }
}
