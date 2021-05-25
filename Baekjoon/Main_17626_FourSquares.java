import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17626_FourSquares {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[1] + dp[i-1];
			for (int j = 2; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
			}
		}
				
		System.out.println(dp[n]);
		
	} // end of main

} // end of class
