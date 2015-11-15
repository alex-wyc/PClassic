import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Shirt {

	static String size(double height, double weight) {
		//TODO: Implement
		return null;
	}

	//main method for reading input for text files
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("ShirtIN.txt"));
		while (in.hasNext()) {
			System.out.println(size(in.nextDouble(), in.nextDouble()));
		}
	}

}
