import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_10826_피보나치수4 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		BigInteger[] fibo = new BigInteger[n+1];
		if (n == 0) {
			System.out.println("0");
			System.exit(0);
		}
		if (n == 1) {
			System.out.println("1");
			System.exit(0);
		}
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
		
		System.out.println(fibo[n]);
	}
}
