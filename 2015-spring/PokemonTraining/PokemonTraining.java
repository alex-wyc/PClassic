import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PokemonTraining {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("PokemonTrainingIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int numPokemon = Integer.parseInt(data[0]);
      int startHP = Integer.parseInt(data[1]);
      int[] damageDealt = new int[numPokemon];
      int[] xpGained = new int[numPokemon];
      for (int i = 0; i < numPokemon; i++) {
        data = br.readLine().split(" ");
        damageDealt[i] = Integer.parseInt(data[0]);
        xpGained[i] = Integer.parseInt(data[1]);
      }
      System.out.println(maxExperienceGained(numPokemon, startHP, damageDealt, xpGained));
    }
    br.close();
  }

  // Fill out the body of this method
  public static int maxExperienceGained(int numPokemon, int startHP, int[] damageDealt, int[] xpGained) {
    int[] a = new int[startHP];
    for (int i = 0 ; i < numPokemon ; i++) {
        if (damageDealt[i] < startHP) {
            a[damageDealt[i]] = xpGained[i];
        }
    }
    //System.out.println(Arrays.toString(a));
    for (int i = 1 ; i < startHP ; i++) {
        for (int j = 1 ; j <= i / 2 ; j++) {
            if (a[j] + a[i - j] > a[i]) {
                a[i] = a[j] + a[i - j];
            }
        }
    }
    return a[startHP - 1];
  }
}
