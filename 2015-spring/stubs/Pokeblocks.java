import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Pokeblocks {

 
 //Make sure before you submit that the main method hasn't been changed!
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader (new FileReader ("PokeblocksIN.txt"));
  
  while (br.ready()) {
    int[] a= new int[7];
   String[] data = br.readLine().split(" ");
   for (int x=0;x<data.length;x++){
     a[x] = Integer.parseInt(data[x]);
   }
   
  }
  br.close();
 }
 
 //Fill out the body of this method
 public static String Pokeblocks(int[] a) {
  return null;
  
 }

}
