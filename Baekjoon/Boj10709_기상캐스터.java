package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10709_기상캐스터 {

	private static int H;
	private static int W;
	private static char[][] map;
	private static int[][] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		ans = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			String s = bf.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				
				if (map[i][j] == '.') {
					if (j == 0) {
						ans[i][j] = -1;
						continue;
					}
					int cnt = 0;
					boolean flag = true;
					for (int k = j-1; k >= 0; k--) {
						if (map[i][k] == 'c') {
							cnt++;
							break;
						}
						else {
							if(k == 0) flag = false;
							cnt++;
						}
					}
					if (!flag) ans[i][j] = -1;
					else ans[i][j] = cnt;
				}
				else if (map[i][j] == 'c'){
					ans[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		

	} // end of main

}
