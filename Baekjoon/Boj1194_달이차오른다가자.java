package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {

	private static int N;
	private static int M;
	private static char[][] map;
	private static int move;
	private static int startX;
	private static int startY;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new char[N][M];
		
		move = Integer.MAX_VALUE;
		startX = 0; // 민식이의 시작위치
		startY = 0; 
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					startY = i;
					startX = j;
				}
			}
		}
		
		
		visited = new boolean[65][N][M];
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startY, startX, 0, 0});// 시작위치, 이동한 횟수, 가지고 있는 열쇠 개수
		visited[0][startY][startX] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int ty = tmp[0];
			int tx = tmp[1];
			int cnt = tmp[2];
			int kcnt = tmp[3];
			
			if (map[ty][tx] == '1') {
				move = move > cnt ? cnt : move;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = ty + dy[i];
				int nx = tx + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if(visited[kcnt][ny][nx]) continue;
				if(map[ny][nx] == '#') continue; // 벽이면 이동 못함
				
				if('a' <= map[ny][nx] && map[ny][nx] <= 'z') { // 소문자 알파벳 
					visited[kcnt | (1<<map[ny][nx]-'a')][ny][nx] = true;
					q.offer(new int[] {ny,nx,cnt+1,kcnt|(1<<map[ny][nx]-'a')});
				}
				if('A' <= map[ny][nx] && map[ny][nx] <= 'F') { // 대문자 알파벳 
					if((kcnt & (1 << (map[ny][nx]-'A'))) != 0) {
						if (!visited[kcnt|(1 << (map[ny][nx]-'A'))][ny][nx]) {
							visited[kcnt|(1 << (map[ny][nx]-'A'))][ny][nx] = true;
							q.offer(new int[] {ny,nx,cnt+1,kcnt|(1 << (map[ny][nx]-'A'))});
						} 
						else continue; 
					}
				}
				else {
					visited[kcnt][ny][nx] = true;
					q.offer(new int[] {ny,nx,cnt+1,kcnt});
				}
			}
		}
		
		if(move == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(move);
		

	} // end of main

} // end of class


