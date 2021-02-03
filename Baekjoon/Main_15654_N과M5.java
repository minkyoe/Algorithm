package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {

	private static int N;
	private static int M;
	private static int[] nums;
	private static int[] selected;
	private static StringBuilder sb;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		selected = new int[M];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		go(1, 0);
		System.out.println(sb);
	} // end of main

	private static void go(int n, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			selected[cnt] = nums[i];
			visited[i] = true;
			go(i+1, cnt+1);
			visited[i] = false;
		}
	}

} // end of class
