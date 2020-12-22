package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[101][101];
		int ans = 0;
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			
			for (int y = sy; y < dy; y++) {
				for (int x = sx; x < dx; x++) {
					if (map[y][x] == 0) {
						map[y][x] = 1;
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);

	} // end of main

} // end of class
