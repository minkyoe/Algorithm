package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트2 {
	private static int N;
	private static int[] arr;
	private static boolean[] selected;
	private static int notSelected;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        
        for (int testCase = 1; testCase <= tc; testCase++) {
			N = Integer.parseInt(bf.readLine()); // 학생 수 
			arr = new int[N+1]; // 0번 안씀
			selected = new boolean[N+1]; // 0번 안씀
			notSelected = N; // 프로젝트 팀에 속하지 못한 학생들의 수
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (i == arr[i]) {
					selected[i] = true;
					--notSelected;
				}
			}
			
			visited = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if(selected[i]) continue;
				visited[i] = true;
				if(dfs(i, i)) {
					selected[i] = true;
				}
			}
			
			System.out.println(notSelected);
		} // end of tc
	} // end of main

	private static boolean dfs(int idx, int root) {
		if (selected[arr[idx]] || visited[arr[idx]]) {
			return false;
		} else {
			if (arr[idx] == root) {
				--notSelected;
				selected[idx] = true;
				return true;
			}
			visited[idx] = true;
			if (dfs(arr[idx], root)) {
				--notSelected;
				selected[idx] = true;
				return true;
			}
		}
		return false;
	}
}
