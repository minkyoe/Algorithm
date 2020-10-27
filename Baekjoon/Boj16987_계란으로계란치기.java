package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기 {
	private static int N;
	private static int[] w;
	private static int[] s;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		s = new int[N]; // 내구도
		w = new int[N]; // 무게
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			s[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0; // 깰 수 있는 계란의 최대 개수
		dfs(0, 0);
		System.out.println(ans);
		
	} // end of main

	private static void dfs(int index, int cnt) {
		if (cnt >= N-1 || index == N) {
			ans = ans < cnt ? cnt : ans;
			return;
		}
		
		if (s[index] <= 0) {
			dfs(index+1, cnt);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (index == i) continue;
			if (s[i] <= 0) continue;
			
			int tmp = 0;
			s[i] -= w[index];
			s[index] -= w[i];
			
			if (s[i] <= 0) tmp++;
			if (s[index] <= 0) tmp++;
			dfs(index+1, cnt+tmp);
			
			s[i] += w[index];
			s[index] += w[i];
			
		}
		
		
	}
} // end of class
