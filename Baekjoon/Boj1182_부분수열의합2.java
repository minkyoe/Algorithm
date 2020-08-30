package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합2 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, S, ans;
	static int[] arr;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		num = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0, 0); // idx, cnt, sum
		
		System.out.println(ans);
	} // end of main

	private static void comb(int idx, int cnt, int sum) {
		if (cnt > 0) {
			if (sum == S) {
				ans++;
			}
		}
	
		for (int i = idx; i < N; i++) {
			comb(i+1, cnt+1, sum+arr[i]);
		}
		
	}
} // end of class
