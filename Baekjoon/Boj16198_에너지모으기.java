package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16198_에너지모으기 {

	private static int N;
	private static int[] energy;
	private static boolean[] visited;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		ans = 0;
		energy = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			energy[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		System.out.println(ans);
		
	} // end of main

	private static void comb(int cnt, int sum) {
		if (cnt == N - 2) {
			ans = ans < sum ? sum : ans;
			return;
		}
		
		for (int i = 1; i < N-1; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			
			int tmp = 1;
			int idx = i;
			while(true) {
				if (!visited[--idx]) {
					tmp *= energy[idx];
					idx = i;
					break;
				}
			}
			while(true) {
				if (!visited[++idx]) {
					tmp *= energy[idx];
					idx = i;
					break;
				}
			}
			
			comb(cnt + 1, sum + tmp);
			visited[i] = false;
		}
		
	}

}
