package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {

	private static int N;
	private static int M;
	private static int[] selected;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		visited = new boolean[N+1];
		
		go(1, 0);

	}

	private static void go(int num, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			selected[cnt] = i;
			visited[i] = true;
			go(i+1, cnt+1);
			visited[i] = false;
		}
		
	}

}
