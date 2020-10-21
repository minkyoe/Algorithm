package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
9
11
2 1
3 1
2 8
2 9
7 8
4 5
6 7
6 3
1 7
6 2
1 9
2
3
3
7
7
2
3
3
4
 */
public class Main_10159_저울 {
	private static int N, M;
	private static int[][] arr;
	static StringTokenizer st;
	private static int[] ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 물건 개수
		M = Integer.parseInt(bf.readLine()); // 미리 측정된 물건 쌍의 개수
		
		arr = new int[N+1][N+1];
		ans = new int[N+1];
		
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		
		for (int k = 1; k <= N; k++) { // 중간
			for (int i = 1; i <= N; i++) { // 시작 
				for (int j = 1; j <= N; j++) { // 끝 
					if (i == k || k == j || j == i) continue;
					if (arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				if (arr[i][j] == 0 && arr[j][i] == 0)
					ans[i]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
		
	} // end of main
} // end of class
