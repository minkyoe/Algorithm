import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16174_점프왕쩰리Large {

	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static boolean ans;
	// 오른쪽, 아래
	private static int[] dr = {0, 1};
	private static int[] dc = {1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		ans = false;
		
		for (int i = 0 ; i < N ; i ++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = map[tr][tc];
			
			if (tr == N-1 && tc == N-1) {
				ans = true;
				break;
			}
			
			for (int i = 0; i < dc.length; i++) {
				int nr = tr + dr[i] * cnt;
				int nc = tc + dc[i] * cnt;
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
		if (ans) System.out.println("HaruHaru");
		else System.out.println("Hing");

	} // end of main

} // end of class
