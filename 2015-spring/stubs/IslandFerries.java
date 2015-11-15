import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Ferry {
  int startIsland;
  int endIsland;
  int ferryCost;
  Ferry(){}
}
public class IslandFerries {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("IslandFerriesIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int numIslands = Integer.parseInt(data[0]);
      int numFerries = Integer.parseInt(data[1]);
      int destIsland = Integer.parseInt(br.readLine());
      Ferry[] ferries = new Ferry[numFerries];
      for (int i = 0; i < numFerries; i++) {
        data = br.readLine().split(" ");
        ferries[i] = new Ferry();
        ferries[i].startIsland = Integer.parseInt(data[0]);
        ferries[i].endIsland = Integer.parseInt(data[1]);
        ferries[i].ferryCost = Integer.parseInt(data[2]);
      }
      System.out.println(minTotalCost(numIslands, numFerries, destIsland, ferries));
    }
    br.close();
  }

  // Fill out the body of this method
  public static int minTotalCost(int numIslands, int numFerries, int destIsland, Ferry[] ferries) {
    return 0;
  }
}
