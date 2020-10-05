package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		int twoCnt = 0;
		int fiveCnt = 0;
		
		for (int i = 2; i <= N; i *= 2) {
			twoCnt += N/i;
		}
		for (int i = 5; i <= N; i *= 5) {
			fiveCnt += N/i;
		}
		
		System.out.println(Math.min(twoCnt, fiveCnt));
	} // end of main
} // end of class
