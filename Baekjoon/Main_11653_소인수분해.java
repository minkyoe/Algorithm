import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11653_소인수분해 {

	private static int N;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		n = N;
		StringBuilder sb = new StringBuilder();
		
		if (N == 1) sb.append("");
		
		while (n > 1) {
			for (int i = 2; i <= N; i++) {
				if (n % i == 0) {
					n /= i;
					sb.append(i).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);

	} // end of main

} // end of class
