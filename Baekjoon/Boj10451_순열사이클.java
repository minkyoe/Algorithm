package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10451_순열사이클2 {
	private static boolean[] visited;
	private static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			int N = Integer.parseInt(bf.readLine()); // 순열의 크기
			map = new int[N+1]; // 0번안씀
			visited = new boolean[N+1];
			int ans = 0; // 사이클 개수
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				if (visited[i]) continue;
				dfs(i);
				ans++;
			}
			
			System.out.println(ans);
			
		} // end of testCase
	
	} // end of main

	private static void dfs(int i) {
		visited[i] = true;
		if (visited[map[i]]) return;
		
		dfs(map[i]);
	}
} // end of class
