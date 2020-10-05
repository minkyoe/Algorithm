package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2004_조합0의개수 {
	private static long n;
	private static long m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		long twoCnt = getCnt(n, 2) - getCnt(n-m, 2) - getCnt(m, 2);
		long fiveCnt = getCnt(n, 5) - getCnt(n-m, 5) - getCnt(m, 5);
		
		System.out.println(Math.min(twoCnt, fiveCnt));
	} // end of main

	private static long getCnt(long num, long count) {
		long result = 0;
		for (long i = count; i <= num; i*=count) {
			result += num/i;
		}
		return result;
	}
} // end of class
