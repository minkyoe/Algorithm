import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2748_피보나치수2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		long[] fibo = new long[n+1];
		if (n == 0) {
			System.out.println("0");
			System.exit(0);
		}
		if (n == 1) {
			System.out.println("1");
			System.exit(0);
		}
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println(fibo[n]);
	}
}
