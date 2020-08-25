import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Boj_2636_치즈 {

	static int R, C; // 세로, 가로 길이
	static int cheeseCnt; // 남아있는 치즈 개수
	static int ansCnt; // 그전 시간에 남아있던 치즈 개수
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int[][] map;
	private static boolean[][] visited;
	static int ansTime = 0;

	// 상 하 좌 우
	static int[] dirY = { -1, 1, 0, 0 };
	static int[] dirX = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeseCnt++;
			}
		}

		while (cheeseCnt > 0) { // 남은 치즈가 0개가 될때까지 반복
			ansTime++;
			ansCnt = cheeseCnt;

			// 공기 있는 부분 -1로 변경
			bfs(0, 0);

			// 공기와 접촉한 치즈 녹이기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						for (int k = 0; k < dirX.length; k++) {
							int nr = i + dirY[k];
							int nc = j + dirX[k];

							if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != -1)
								continue;
							cheeseCnt--; // 치즈 개수 감소
							map[i][j] = 0; // 녹음
							break;
						}
					}
				}
			}
		} // end of while

		System.out.println(ansTime);
		System.out.println(ansCnt);

	} // end of main

	private static void bfs(int r, int c) {
		visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;
		map[r][c] = -1;

		while (!q.isEmpty()) {
			int tr = q.peek()[0];
			int tc = q.peek()[1];
			q.poll();

			for (int i = 0; i < dirX.length; i++) {
				int nr = tr + dirY[i];
				int nc = tc + dirX[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 1)
					continue;
				map[nr][nc] = -1;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}

	}

} // end of class
