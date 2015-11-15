import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PewterCity {
	
	public static int pathsToPewter(String iRom, String uRom){
		//TODO Implement
		return -1;	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("PewterCityIN.txt"));
		
		while(reader.ready()){
			String i = reader.readLine(); //First input on first line
			String u = reader.readLine(); //Second input on second line
			System.out.println(pathsToPewter(i, u));
		}
		
		reader.close();
	}
	
}
