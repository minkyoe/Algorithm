import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16932_모양만들기 {

	private static int N, M, ans;
	private static int[][] map;
	private static int[][] group;
	private static int[] groupCnt;
	private static boolean[][] visited;
	private static ArrayList<int[]> zeros;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		group = new int[N][M];
		groupCnt = new int[1000001];
		ans = Integer.MIN_VALUE;
		zeros = new ArrayList<int[]>();
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 1) group[i][j] = -1;
				else if (map[i][j] == 0) zeros.add(new int[] {i,j});
					
			}
		}
		
		// 모여있는 1 묶기
		int groupIdx = 1;
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (group[r][c] == -1) {
					visited[r][c] = true;
					
					int cnt = dfs(r, c, groupIdx);
					groupCnt[groupIdx] = cnt;
					++groupIdx;
				} // end of if
			}
		}
		
		// 0의 위치에서 탐색
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < zeros.size(); i++) {
			int r = zeros.get(i)[0];
			int c = zeros.get(i)[1];
			int sum = 1;
			visited.clear();
			for (int k = 0; k < dr.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) continue;
				if (group[nr][nc] != 0) {
					int idx = group[nr][nc];
					if (visited.contains(idx)) continue;
					visited.add(idx);
					sum += groupCnt[idx];
				}
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	} // end of main

	private static int dfs(int r, int c, int idx) {
		group[r][c] = idx;
		int tmpCnt = 1;
		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
			visited[nr][nc] = true;
			tmpCnt += dfs(nr, nc, idx);
		}
		return tmpCnt;
	}

} // end of class
