package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2529_부등호 {

	private static int N;
	private static char[] sign;
	private static int[] selected;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		sign = new char[N];
		selected = new int[N+1];
		visited = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		// 최대값 구하기
		getMax(0);
		for (int i = 0; i < N+1; i++) {
			System.out.print(selected[i]);
		}
		System.out.println();
		
		// 초기화
		Arrays.fill(selected, 0);
		Arrays.fill(visited, false);

		// 최소값 구하기
		getMin(0);
		for (int i = 0; i < N+1; i++) {
			System.out.print(selected[i]);
		}
		
	} // end of main

	private static boolean getMin(int cnt) {
		if (cnt == N+1) {
			if(check()) return true;
			return false;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (visited[i]) continue;
			selected[cnt] = i;
			visited[i] = true;
			if (getMin(cnt+1)) return true;
			visited[i] = false;
		}
		
		return false;
	}

	private static boolean getMax(int cnt) {
		if (cnt == N+1) {
			if(check()) return true;
			return false;
		}
		
		for (int i = 9; i >= 0; i--) {
			if (visited[i]) continue;
			selected[cnt] = i;
			visited[i] = true;
			if (getMax(cnt+1)) return true;
			visited[i] = false;
		}
		
		return false;
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			char s = sign[i];
			
			if (s == '<') {
				if (selected[i] > selected[i+1]) return false;
			}
			else if (s == '>') {
				if (selected[i] < selected[i+1]) return false;
			}
		}
		return true;
	}

} // end of class
