import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


public class DiglettsCave {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				"DiglettsCaveIN.txt"));

		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			int r = Integer.parseInt(data[0]);
			int c = Integer.parseInt(data[1]);
			int sr = Integer.parseInt(data[2]);
			int sc = Integer.parseInt(data[3]);
			int er = Integer.parseInt(data[4]);
			int ec = Integer.parseInt(data[5]);
			int[][] cave = new int[r][c];
			for (int row = 0; row < r; row++) {
				String line = br.readLine();
				for (int col = 0; col < c; col++) {
					cave[row][col] = Integer.parseInt(""+line.charAt(col));
				}
			}
			System.out.println(minimumSmashes(cave, sr, sc, er, ec));
		}
		br.close();

	}
	
	public static int minimumSmashes(int[][] cave, int sr,
					 int sc, int er, int ec) {
	    //Fill out the body of this method
	    
	}
	
}
