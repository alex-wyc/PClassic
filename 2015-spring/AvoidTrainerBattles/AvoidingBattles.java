import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AvoidingBattles {

    public static int[][] reachAble;
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
      reachAble = MakeIntArr(map);
      setReach(0, 0);
      return reachAble[reachAble.length - 1][reachAble[0].length - 1] != 0;
  }

  public static boolean setReach(int m, int n) {
      if ((m < 0) || (m >= reachAble.length))
          return false;
      if ((n < 0) || (n >= reachAble[0].length))
          return false;
      if (reachAble[m][n] != 0)
          return false;

      reachAble[m][n] = 1;
      setReach(m - 1, n);
      setReach(m + 1, n);
      setReach(m, n - 1);
      setReach(m, n + 1);
      return false;
  }

  public static int[][] MakeIntArr(char[][] board){
      int t = 0;
      int[][] out = new int[board.length][board[0].length];
      for (int i = 0 ; i < board.length ; i++) {
        for (int j = 0 ; j <  board[0].length ; j++) {
            if (board[i][j] == '>') {
                t = j;
                while (t < board[0].length) {
                    out[i][t] = -1;
                    if (board[i][t] == '#' || board[i][t] == 'v'|| board[i][t] == '^'|| board[i][t] == '<') {
                        break;
                    }
                    t++;
                }
            }
            if (board[i][j] == '<') {
                t = j;
                while (t >= 0) {
                    out[i][t] = -1;
                    if (board[i][t] == '#' || board[i][t] == 'v'|| board[i][t] == '^'|| board[i][t] == '>') {

                        break;
                    }
                    t--;
                }
            }

            if (board[i][j] == '^') {
                t = i;
                while (t >= 0) {
                    out[t][j] = -1;
                    if (board[t][j] == '#' || board[t][j] == 'v'|| board[t][j] == '<'|| board[t][j] == '>') {

                        break;
                    }
                    t--;
                }
            }

            if (board[i][j] == 'v') {
                t = i;
                while (t < board.length) {
                    out[t][j] = -1;
                    if (board[t][j] == '#' || board[t][j] == '^'|| board[t][j] == '<'|| board[t][j] == '>') {

                        break;
                    }
                    t++;
                }
            }
        }
      }

      out[0][0] = 0;
      return out;
  }
}
