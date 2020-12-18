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
	private static int[][] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		map = new int[H+X][W+Y];
		ans = new int[H][W];
		
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < W+Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] before = new int[H][W];
		int[][] after = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				before[i][j] = map[i][j];
			}
		}
		for (int i = X; i < H+X; i++) {
			for (int j = Y; j < W+Y; j++) {
				after[i-X][j-Y] = map[i][j];
			}
		}
//		System.out.println("---before---");
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(before[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("---after---");
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(after[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (before[i][j] == after[i][j]) ans[i][j] = before[i][j];
				else {
					int tmp = after[i][j] - before[i][j];
					if (tmp < 0) ans[i-X][j-Y] = tmp * -1;
					else ans[i+X][j+Y] = tmp;
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

} // end of class
