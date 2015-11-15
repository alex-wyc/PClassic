import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AsteroidMining {

    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("AsteroidMiningIN.txt"));

        while (br.ready()) {
            int numChambers = Integer.parseInt(br.readLine());
            int[] leftChamber = new int[numChambers];
            int[] rightChamber = new int[numChambers];
            for (int i = 0; i < numChambers; i++) {
                String[] chambers = br.readLine().split(" ");
                leftChamber[i] = Integer.parseInt(chambers[0]);
                rightChamber[i] = Integer.parseInt(chambers[1]);
            }
            boolean answer = isSymmetric(numChambers, leftChamber, rightChamber);
            System.out.println((answer) ? "Y" : "N");
        }
        br.close();
    }

    // Fill out the body of this method
    public static boolean isSymmetric(
            int numChambers, 
            int[] leftChamber, 
            int[] rightChamber) {
        

        if (leftChamber[0] == -1 && rightChamber[0] == -1) {
            return true;
        }
        else if (leftChamber[0] != -1 && rightChamber[0] != -1) {
            return foo(leftChamber[0], rightChamber[0], leftChamber, rightChamber);
        }
        else {
            return false;
        }
    }

    public static boolean foo(int x, int y, int[] leftChamber, int[] rightChamber) {
        int lx = leftChamber[x];
        int rx = rightChamber[x];
        int ly = leftChamber[y];
        int ry = rightChamber[y];

        boolean one = false;
        if (lx == -1 && ry == -1) {
            one = true;
        }
        else if (lx != -1 && ry != -1) {
            one = foo(lx, ry, leftChamber, rightChamber);
        }

        boolean two = false;
        if (ly == -1 && rx == -1) {
            two = true;
        }
        else if (ly != -1 && rx != -1) {
            two = foo(rx, ly, leftChamber, rightChamber);
        }
       
        return one && two;
    }
}
