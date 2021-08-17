import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934_최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");	
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int ans = (A * B) / getGCD(A, B);
			
			System.out.println(ans);
		} // end of tc
		
	} // end of main

	private static int getGCD(int a, int b) {
		int A = Math.min(a, b);
		int B = Math.max(a, b);
		while (B != 0) {
			int tmp = B;
			B = A % B;
			A = tmp;
		}
		
		return A;
	}

} // end of class
