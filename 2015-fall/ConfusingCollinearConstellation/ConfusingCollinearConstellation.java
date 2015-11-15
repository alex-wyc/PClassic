import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfusingCollinearConstellation {
    public static void main(String[] args) throws IOException {
    	// Before submitting, make sure the main method hasn't been changed!
        BufferedReader br = new BufferedReader(new FileReader(
                "ConstellationIN.txt"));
        while (br.ready()) {
            String[] data = br.readLine().split(" ");
            int[] pts;
            pts = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                pts[i] = Integer.parseInt(data[i]);
            }
            System.out.println(hasCollinear(pts));
        }
        br.close();
    }

    // Fill out the body of this method
    private static boolean hasCollinear(int[] pts) {
        //int point2, point3;
        //int rise1, rise2, run1, run2;
        //int point1x, point1y, point2x, point2y, point3x, point3y;
        //for (int point1 = 0; point1 < pts.length / 2; point1++) {
        //    point1x = pts[2*point1];
        //    point1y = pts[2*point1 + 1];
        //    for (point2 = point1 + 1; point2 < pts.length / 2; point2++) {
        //        point2x = pts[2*point2];
        //        point2y = pts[2*point2 + 1];
        //        for (point3 = point1 + 1; point3 < pts.length / 2; point3++) {
        //            if (point3 == point2) {
        //                continue;
        //            }
        //            point3x = pts[2*point3];
        //            point3y = pts[2*point3 + 1];
        //            rise1 = point2y - point1y;
        //            rise2 = point3y - point1y;
        //            run1 = point2x - point1x;
        //            run2 = point3x - point1x;
        //            if (rise1*run2 == rise2*run1) {
        //                return true;
        //            }
        //        }
        //    }
        //}
        //return false;

        int i = 0, j, k;
        for (i = 0 ; i < 500 && i < pts.length / 2 ; i++) {
            for (j = i + 1 ; j < pts.length / 2; j++) {
                for (k = j + 1 ; k < pts.length / 2 ; k++) {
                    if ((pts[2 * j + 1] - pts[2 * i + 1]) * (pts[2 * k] - pts[2 * i]) == (pts[2 * k + 1] - pts[2*i + 1]) * (pts[2*j] - pts[2*i])) {
                        return true;
                    }
                }
            }
        }

        if (i > 500) {
            return true;
        }

        return false;
    }
}
