import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ProfessorOak {
	
	public static int professorOak(int lim){
		//TODO Implement
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("ProfessorOakIN.txt"));
						
		while(reader.ready()){
			int i = new Integer(reader.readLine());
			System.out.println(professorOak(i));
		}
		reader.close();
	}
	
}
