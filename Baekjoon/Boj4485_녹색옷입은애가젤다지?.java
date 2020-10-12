package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_4485_녹색옷입은애가젤다지 {
	private static int N;
	private static int[][] dist;
	private static int[][] rupee;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int problem = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			problem++;
			N = Integer.parseInt(bf.readLine());
			
			if (N == 0) break;
			
			dist = new int[N][N];
			rupee = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = bf.readLine();
				for (int j = 0, index = 0; j < N; j++, index+=2) {
					rupee[i][j] = s.charAt(index) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dist[0][0] = rupee[0][0];
			visited[0][0] = true;
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.offer(new Point(0,0,dist[0][0]));
			
			while(!pq.isEmpty()) {
				Point p = pq.poll();
				int ty = p.y;
				int tx = p.x;
				int weight = p.weight;
				
				for (int i = 0; i < 4; i++) {
					int ny = ty + dy[i];
					int nx = tx + dx[i];
					
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if (visited[ny][nx]) continue;
					if (dist[ny][nx] < weight + rupee[ny][nx]) continue;
					
					visited[ny][nx] = true;
					dist[ny][nx] = weight + rupee[ny][nx];
					pq.offer(new Point(ny, nx, dist[ny][nx]));
				
				}
			}
			System.out.println("Problem " + problem + ": " + dist[N-1][N-1]);
			
			
		}
	} // end of main
} // end of class

class Point implements Comparable<Point>{
	int y;
	int x;
	int weight;
	
	public Point() {
	}

	public Point(int y, int x, int weight) {
		super();
		this.y = y;
		this.x = x;
		this.weight = weight;
	}

	@Override
	public int compareTo(Point o) {
		return this.weight - o.weight;
	}
	
}
