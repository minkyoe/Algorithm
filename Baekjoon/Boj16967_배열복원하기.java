package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16967_배열복원하기 {

	private static int H;
	private static int W;
	private static int X;
	private static int Y;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		map = new int[H+X][W+Y];
		
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < W+Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int tr = X; tr < H; tr++) {
			for (int tc = Y; tc < W; tc++) {
				map[tr][tc] = map[tr][tc] - map[tr-X][tc-Y];
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	} // end of main

} // end of class
