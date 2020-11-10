package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트2 {
	private static int N;
	private static int[] arr;
	private static boolean[] done;
	private static boolean[] visited;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        
        for (int testCase = 1; testCase <= tc; testCase++) {
			N = Integer.parseInt(bf.readLine()); // 학생 수 
			arr = new int[N+1]; // 0번 안씀
			cnt = 0;
			done = new boolean[N+1]; // 0번 안씀
			visited = new boolean[N+1];
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) dfs(i);
			}
			
			System.out.println(N-cnt);
		} // end of tc
	} // end of main

	private static void dfs(int num) {
		visited[num] = true;
		int next = arr[num];
		
		if (!visited[next]) dfs(next);
		else {
			if (!done[next]) {
				for (int i = next; i != num; i = arr[i]) {
					cnt++;
				}
				cnt++; // 자기자신
			}
		}
		done[num] = true;
	}
}
