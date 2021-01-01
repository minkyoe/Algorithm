package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_1940_주몽2 {

	private static int N;
	private static int M;
	private static int[] arr;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		arr = new int[N];
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N - 1; i++) {
ex:			for (int j = i + 1; j < N; j++) {
				if (arr[i] + arr[j] == M) {
					++ans;
					break ex;
				}
			}
		}
		
		System.out.println(ans);
	}

}
