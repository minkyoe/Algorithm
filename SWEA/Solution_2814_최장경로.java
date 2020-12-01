package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2814_최장경로2 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[] visited;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 정점 개수
			M = Integer.parseInt(st.nextToken()); // 간선 개수
			map = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a  = Integer.parseInt(st.nextToken());
				int b  = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
				map[b][a] = 1;
			}
			
			ans  = 0;
			for (int from = 1; from <= N; from++) {
				visited[from] = true;
				dfs(from, 1);
				visited[from] = false;
				
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ").append(ans);
			System.out.println(sb);
		} // end of testCase
		

	} // end of main

	private static void dfs(int v, int cnt) {
		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1 && v != i && !visited[i]) {
				visited[i] = true;
				dfs(i, cnt+1);
				visited[i] = false;
			}
		}
		
		ans = ans < cnt ? cnt : ans;
	}

}
