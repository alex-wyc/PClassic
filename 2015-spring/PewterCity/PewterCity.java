import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.lang.Integer;



public class PewterCity {
	
	public static int pathsToPewter(String iRom, String uRom){
		//TODO Implement
		Hashtable<String, Integer> map = new Hashtable<String, Integer>();
        map.put("I", new Integer(1));
        map.put("V", new Integer(5));
        map.put("X", new Integer(10));
        map.put("L", new Integer(50));
        map.put("C", new Integer(100));
		int pos = 0;
		int valueHere, valueNext, I = 0, U = 0;
		long result = 1;
		for (pos = 0 ; pos < iRom.length() - 1 ; pos++) {
            valueHere = map.get(iRom.substring(pos, pos + 1)).intValue();
            valueNext = map.get(iRom.substring(pos + 1, pos + 2)).intValue();
            if (valueNext > valueHere) {
                I -= valueHere;
            }
            else {
                I += valueHere;
            }
        }
        I += map.get(iRom.substring(iRom.length() - 1, iRom.length())).intValue();

		for (pos = 0 ; pos < uRom.length() - 1 ; pos++) {
            valueHere = map.get(uRom.substring(pos, pos + 1)).intValue();
            valueNext = map.get(uRom.substring(pos + 1, pos + 2)).intValue();
            if (valueNext > valueHere) {
                U -= valueHere;
            }
            else {
                U += valueHere;
            }
        }
        U += map.get(uRom.substring(uRom.length() - 1, uRom.length())).intValue();
        for (pos = I ; pos > I - U ; pos--) {
            result *= pos;
//            System.out.println("result Top " + result);
        }
        for (pos = 1 ; pos <= U ; pos++) {
            result /= pos;
//            System.out.println("result Bottom " + result);
        }
//        System.out.printf("%d, %d\n", I, U);
		return (int)result;
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
