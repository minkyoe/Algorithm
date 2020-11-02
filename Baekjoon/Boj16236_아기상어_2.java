package 알고리즘_보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16236_아기상어 {
	private static int N;
	private static int[][] map;
	private static int sharkY;
	private static int sharkX;
	private static int sharkSize;
	private static int time;
	private static ArrayList<Fish> fishes;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static int eaten;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 공간 크기
		map = new int[N][N];
		time = 0;
		eaten = 0;
		sharkSize = 2;
		fishes = new ArrayList<Fish>();
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index=0; j < N; j++,index+=2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 9) {
					sharkY = i;
					sharkX = j;
				}
			}
		}
		
		while(true) {
			fishes.clear();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] != 9 && map[i][j] < sharkSize) {
						int dist = bfs(i, j);
						if (dist == 0) continue;
						fishes.add(new Fish(i,j,dist));
					}
				}
			}
			if (fishes.size() == 0) break;
			
			Collections.sort(fishes);
			int idx = 0;
			for (idx = 0; idx < fishes.size(); idx++) {
				if (fishes.get(idx).dist != Integer.MAX_VALUE) break; 
			}
			
			if (idx == fishes.size()) break;
			int targetY = fishes.get(idx).y;
			int targetX = fishes.get(idx).x;
			
			++eaten;
			if(sharkSize == eaten) {
				++sharkSize;
				eaten=0;
			}
			map[targetY][targetX] = 0;
			map[sharkY][sharkX] = 0;
			sharkY = targetY;
			sharkX = targetX;
			map[sharkY][sharkX] = 9;
			
			
			time += fishes.get(idx).dist;
			
		}
		
		System.out.println(time);
		
		
	} // end of main

	private static int bfs(int Y, int X) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.offer(new int[] {sharkY, sharkX, 0});
		visited[sharkY][sharkX] = true;
		int dist = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int ty = tmp[0];
			int tx = tmp[1];
			dist = tmp[2];
			
			if (ty == Y && tx == X) {
				return dist;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = ty + dy[i];
				int nx = tx + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
				if (map[ny][nx] > sharkSize) continue;
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx, dist+1});
			}
		}
		return Integer.MAX_VALUE;
	}
}

class Fish implements Comparable<Fish>{
	int y;
	int x;
	int dist;
	
	public Fish() {
		// TODO Auto-generated constructor stub
	}

	public Fish(int y, int x, int dist) {
		super();
		this.y = y;
		this.x = x;
		this.dist = dist;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.dist == o.dist) {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
		return this.dist - o.dist;
	}
	
	
}