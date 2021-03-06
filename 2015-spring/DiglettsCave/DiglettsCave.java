import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;


public class DiglettsCave {

    int[][] array;
    int[][] breaksToGetHere;
    boolean[][] beenHere;
    int rows, cols;

    public DiglettsCave(int[][] cave, int r, int c) {
        array = cave;
        rows = r;
        cols = c;
        beenHere = new boolean[r][c];
        breaksToGetHere = new int[r][c];
    }

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
			DiglettsCave dc = new DiglettsCave(cave, r, c);
			dc.recurse(sr, sc, 0);
			System.out.println(dc.minimumSmashes(er, ec));
		}
		br.close();

	}
	
	public int minimumSmashes(int er, int ec) {
	    if (beenHere[er][ec])
	        return breaksToGetHere[er][ec];
        else return -1;
	}

	public void recurse(int row, int col, int rocksBroken) {
        if (array[row][col] == 2)
            return;
        if (array[row][col] == 1)
            rocksBroken++;
        if (beenHere[row][col] && breaksToGetHere[row][col] <= rocksBroken)
            return;
        breaksToGetHere[row][col] = rocksBroken;
        beenHere[row][col] = true;
        if (row > 0)
            recurse(row - 1, col, rocksBroken);
        if (row < rows - 1)
            recurse(row + 1, col, rocksBroken);
        if (col > 0)
            recurse(row, col - 1, rocksBroken);
        if (col < cols - 1)
            recurse(row, col + 1, rocksBroken);
    }
	
}
