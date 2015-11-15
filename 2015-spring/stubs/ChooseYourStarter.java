import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ChooseYourStarter {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("ChooseYourStarterIN.txt"));
    while (br.ready()) {
      String battleTypes = br.readLine();
      System.out.println(chooseStarter(battleTypes));
    }
    br.close();
  }

  // Fill out the body of this method
  public static String chooseStarter(String battleTypes) {
    return "pikachu";
  }
}
