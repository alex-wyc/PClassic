import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class RocketBoxes {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(
				"RocketBoxesIN.txt"));

		while (br.ready()) {
			System.out.println(ways(Integer.parseInt(br.readLine())));
		}
		br.close();
	}
	public static int ways(int size) {
	    //Fill out the body of the stub
	}
}
