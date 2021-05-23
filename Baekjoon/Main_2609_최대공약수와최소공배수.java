import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {

	private static int a, b;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
        int gcd = GCD(a, b);
		 System.out.println(gcd + " " + (a*b)/gcd);
	} // end of main
    public static int GCD(int aa, int bb) {
        while (bb != 0) {
            int r = aa % bb;
            aa = bb;
            bb = r;
        }
        return aa;
    }

} // end of class
