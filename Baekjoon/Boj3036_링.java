package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3036_링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int first = arr[0];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			int gcd = getGCD(first, arr[i]);
			sb.append(first/gcd).append("/").append(arr[i]/gcd).append("\n");
		}
		System.out.println(sb);
	}

	private static int getGCD(int first, int next) {
		int a = first;
		int b = next;
		
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	} 

}
