package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// (A + B) MOD C = (( A MOD C) + (B MOD C)) MOD C

public class Main_11057_오르막수 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		long[][] arr = new long[N+1][10];
		
		for (int i = 0; i <= 9; i++) {
			arr[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					arr[i][j] += (arr[i-1][k] % 10007);
				}
			}
		}
		
		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += arr[N][i];
		}
		System.out.println(ans % 10007);
	} // end of main
}
