package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {

	private static int N;
	private static int M;
	private static int[] selected;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		selected = new int[M];
		go(1, 0);
		System.out.println(sb);
	}

	private static void go(int num, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			selected[cnt] = i;
			go(i+1, cnt+1);
		}
		
	}

}
