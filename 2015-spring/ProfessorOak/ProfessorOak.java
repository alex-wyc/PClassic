import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.Arrays;


public class ProfessorOak {
	
	public static int professorOak(int lim){
		//TODO Implement
		int c = 0;
		int x = 0;
        for (int i = 2 ; (x = i * (i + 1)) <= lim ; i++) {
            c += lim / x;
        }
		for (int j = 2 ; (2 * j + 1) * (j + 1) <= lim ; j++) {
		    boolean[] tmp = new boolean[j];
		    tmp[0] = true;
		    for (int k = 2 ; k <= j / 2 ; k++) {
                if (j % k == 0) {
                    int l = k;
                    while (l < j) {
                        tmp[l] = true;
                        l += k;
                    }
                }
            }
            
//            System.out.println(Arrays.toString(tmp));
         	for (int d = 2 * j; d * (d - j) < lim ; d+=j) {
                for (int e = 0 ; e < j ; e++) {
                    if (!tmp[e]) {
                        int f = e + d;
                        //System.out.println("f processed: " + f*(f - j));
                        c += lim / (f * (f - j));
         	        }
                }
            }
        }
		return c;
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
