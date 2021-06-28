import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20053_최소최대2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				if (tmp > max) max = tmp;
				if (tmp < min) min = tmp;
			}
			
			System.out.println(min + " " + max);
		} // end of tc

	} // end of main
 
} // end of class
