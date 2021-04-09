import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라 {

	private static int N, M, T, gramY, gramX;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		gramY = 0; gramX = 0;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 2) {
					gramY = i;
					gramX = j;
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		int noGramCnt = bfs(0, 0, N-1, M-1, false);
		if (noGramCnt != -1) ans = Math.min(ans, noGramCnt);
		
		int withGramCnt = bfs(0, 0, gramY, gramX, false);
		if (withGramCnt == -1) { // 그람을 얻을 수 없다면
			if (ans == Integer.MAX_VALUE) // 그람 없을 때도 도착할 수 없다면
				System.out.println("Fail");
			else {
				if (ans <= T) System.out.println(ans); // 제한 시간 내에 도착한다면
				else System.out.println("Fail");
			}
		} else { // 그람 얻을 수 있다면
			withGramCnt += bfs(gramY, gramX, N-1, M-1, true);
			ans = Math.min(ans, withGramCnt);
			if (ans <= T) System.out.println(ans); // 제한 시간 내에 도착한다면
			else System.out.println("Fail");
		}
	} // end of main

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int bfs(int startY, int startX, int destY, int destX, boolean withGram) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startY, startX, 0});
		visited[startY][startX] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			if (tr == destY && tc == destX) {
				return cnt;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				if (!withGram && map[nr][nc] == 1) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		
		return -1;
	}

} // end of class
