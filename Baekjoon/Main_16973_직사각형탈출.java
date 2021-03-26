import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {

	private static int N, M, H, W, startY, startX, endY, endX;
	private static int[][] board;
	private static ArrayList<int[]> wall;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		wall = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				board[i][j] = s.charAt(index) - '0';
				if (board[i][j] == 1) wall.add(new int[] {i, j});
			}
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		startX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(startY-1, startX-1));
	} // end of main

	private static int bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] {y, x, 0});
		visited[y][x] = true;
		int ans = -1;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int ty = tmp[0];
			int tx = tmp[1];
			int cnt = tmp[2];
			
			if (ty == endY-1 && tx == endX-1) {
				ans = cnt;
				break;
			}
			
ex:			for (int i = 0; i < dr.length; i++) {
				int ny = ty + dr[i];
				int nx = tx + dc[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (ny + H > N || nx + W > M) continue;
				if (visited[ny][nx]) continue;
				
				int ey = ny + H - 1;
				int ex = nx + W - 1;
				
				// 직사각형 안에 벽이 있는지 체크
				for (int j = 0; j < wall.size(); j++) {
					int[] w = wall.get(j);
					int wy = w[0];
					int wx = w[1];
					if (ny <= wy && wy <= ey && nx <= wx && wx <= ex) continue ex;
				}
				
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx, cnt+1});
			}
		}
		
		return ans;
	}

} // end of class
