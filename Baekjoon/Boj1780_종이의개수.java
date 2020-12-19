package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {

	private static int N;
	private static int[][] map;
	private static int[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		ans = new int[3]; // -1, 0, 1
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recur(0, 0, N);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	} // end of main

	private static void recur(int r, int c, int size) {
		if (size == 1) {
			ans[map[r][c]+1] += 1;
			return;
		}
		
		int num = map[r][c];
		boolean isSame = true;
ex:		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if (num != map[i][j]) {
					isSame = false;
					break ex;
				}
			}
		}
		
		if (isSame) {
			ans[num+1] += 1;
			return;
		}
		
		int n = (int)Math.sqrt(size*size/9);
		for (int i = r; i < r+size; i+=n) {
			for (int j = c; j < c+size; j+=n) {
				recur(i, j, n);
			}
		}
	}

} // end of class
