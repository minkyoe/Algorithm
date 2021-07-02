import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;
	private static ArrayList<Integer> ans;
	private static int villageCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		ans = new ArrayList<Integer>();
		villageCnt = 0;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					++villageCnt;
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(villageCnt);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	} // end of main
	
	// 방향 : 상, 하, 좌, 우 
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs(int r , int c) {
		int cnt = 1;
		
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc] || arr[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
				++cnt;
			}
		}
		
		ans.add(cnt);
	}

} // end of class
