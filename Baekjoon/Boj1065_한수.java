package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1065_한수 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int ans = 99;
		
		if (N < 100) ans = N;
		else {
			for (int i = 100; i <= N; i++) {
				String s = String.valueOf(i);
				int diff = (s.charAt(0) - '0') - (s.charAt(1) - '0');
				for (int j = 0; j < s.length() - 1; j++) {
					if (((s.charAt(j) - '0') - (s.charAt(j+1) - '0')) != diff) break;
					else if (j == s.length() - 2) ++ans;
				}
			}
		}
		
		System.out.println(ans);
	}

}
