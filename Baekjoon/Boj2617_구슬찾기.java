package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기 {

	private static int N;
	private static int M;
	private static int[][] arr;
	private static int limit;
	private static boolean[] isAns;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		limit = (N+1)/2;
	
		arr = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		for (int i = 1; i <= N; i++) { // 경유
			for (int j = 1; j <= N; j++) { // 출발
				for (int k = 1; k <= N; k++) { // 도착
					if (i == j || j == k || i == k) continue;
					if (arr[j][i] == 1 && arr[i][k] == 1) {
						arr[j][k] = 1;
					}
				}
			}
		}
		
		isAns = new boolean[N+1];
		ans = 0;
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if(arr[i][j] == 1) ++cnt;
			}
			if (cnt >= limit) {
				++ans;
				isAns[i] = true;
			}
		}
		for (int i = 1; i <= N; i++) {
			if(isAns[i]) continue;
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if(arr[j][i] == 1) ++cnt;
			}
			if (cnt >= limit) {
				++ans;
				isAns[i] = true;
			}
		}
		
		System.out.println(ans);

	} // end of main

} // end of class
