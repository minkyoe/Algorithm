package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_1249_보급로2 {
	private static int N;
	private static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(bf.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = bf.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ").append(dijkstra(0,0,N-1,N-1));
			System.out.println(sb.toString());
		} // end of tc
	} // end of main

	private static int dijkstra(int sy, int sx, int ey, int ex) {
		boolean[][] visited = new boolean[N][N];
		int[][] min = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				min[i][j] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<Road> pq = new PriorityQueue<>();
		
		min[sy][sx] = 0;
		pq.offer(new Road(sy,sx, min[sy][sx]));
		
		while(true) {
			Road v = pq.poll();
			int ty = v.y;
			int tx = v.x;
			int cost = v.cost;

			visited[ty][tx] = true;
			if (ty == ey && tx == ex) return cost;
			
			for (int d = 0; d < 4; d++) {
				int ny = ty + dy[d];
				int nx = tx + dx[d];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]
						&& min[ny][nx] > cost + map[ny][nx]) {
					min[ny][nx] = cost + map[ny][nx];
					pq.offer(new Road(ny,nx, min[ny][nx]));
				}
			}
		}
	}
}

class Road implements Comparable<Road>{
	int y;
	int x;
	int cost;
	
	public Road() {
	}
	
	
	public Road(int y, int x, int cost) {
		super();
		this.y = y;
		this.x = x;
		this.cost = cost;
	}


	@Override
	public int compareTo(Road o) {
		return this.cost - o.cost;
	}

}
