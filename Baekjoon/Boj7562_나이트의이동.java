package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {

	// 나이트 이동 방향
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int N;
	private static int fromR;
	private static int fromC;
	private static int toR;
	private static int toC;
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= tc; i++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			fromR = Integer.parseInt(st.nextToken());
			fromC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine(), " ");
			toR = Integer.parseInt(st.nextToken());
			toC = Integer.parseInt(st.nextToken());
			
			if (fromR == toR && fromC == toC) System.out.println("0");
			else System.out.println(bfs(fromR, fromC, toR, toC));
			
		} // end of testCase

	} // end of main

	private static int bfs(int fr, int fc, int tr, int tc) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {fr, fc, 0});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int nowR = tmp[0];
			int nowC = tmp[1];
			int nowCnt = tmp[2];
			
			if (nowR == tr && nowC == tc) {
				return nowCnt;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int newR = nowR + dr[i];
				int newC = nowC + dc[i];
				
				if (newR >= N || newR < 0 || newC >= N || newC < 0) continue;
				if (map[newR][newC] == 0) {
					map[newR][newC] = nowCnt + 1;
					q.offer(new int[] {newR, newC, nowCnt+1});
				}
			}
		}
		return 0;
	}

} // end of class
