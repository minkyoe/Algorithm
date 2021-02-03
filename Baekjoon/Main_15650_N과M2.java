package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {

	private static int M;
	private static int N;
	private static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
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
		
		for (int i = num; i <= N; i++) {
			selected[cnt] = i;
			go(i+1, cnt+1);
		}
		
	}

}
