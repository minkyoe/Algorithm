import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11909_배열탈출 {

	private static int n, ans;
	private static int[][] map;
	private static boolean[][] visited;
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int w;
		
		Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		public int compareTo(Point p) {
			return this.w - p.w;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dijkstra(0, 0);
		System.out.println(ans);
		
	} // end of main

	// 오른쪽, 아래 
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	private static void dijkstra(int r, int c) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(r, c, 0));
		
		while (!pq.isEmpty()) {
			Point tmp = pq.poll();
			int tr = tmp.r;
			int tc = tmp.c;
			int tw = tmp.w;
			
			if (tr == n-1 && tc == n-1) {
				ans = tw;
				break;
			}
			
			// pq에서 꺼내고 나서 여기서 방문 체크 해줘야함 (pq에 넣을때 방문체크 해버리면 도달 할 수 있는 지점들에 다 방문 못하니까) 
			if (!visited[tr][tc]) {
				visited[tr][tc] = true;
				
				for (int i = 0; i < dc.length; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
					
					int weight = map[nr][nc] - map[tr][tc];
					if (weight < 0) weight = 0;
					else if (weight == 0) weight = 1;
					else weight += 1;
					
					pq.offer(new Point (nr, nc, tw + weight));
				}
			} // end of visited
		}
		
	}

} // end of class
