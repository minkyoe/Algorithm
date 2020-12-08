package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18429_근손실 {

	private static int N;
	private static int K;
	private static int[] kit;
	private static int ans;
	private static int[] selected;
	private static boolean[] visited;
	private static final int LIMIT = 500;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // N일, N개 키트
		K = Integer.parseInt(st.nextToken()); // 하루에 감소하는 양
		kit = new int[N];
		selected = new int[N];
		visited = new boolean[N];
		ans = 0;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0);
		System.out.println(ans);

	} // end of main

	private static void comb(int cnt) {
		if (cnt == N) {
			if(check()) {
				++ans;
			}
			return;
		}
		
		for (int idx = 0; idx < N; idx++) {
			if(visited[idx]) continue;
			visited[idx] = true;
			selected[cnt] = idx;
			comb(cnt+1);
			visited[idx] = false;
		}
		
		
	}

	private static boolean check() {
		int weight = LIMIT;
		for (int i = 0; i < N; i++) {
			weight = weight - K + kit[selected[i]];
			if (weight < LIMIT) return false;
		}
		return true;
	}

} // end of class
