import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C; // 세로, 가로

	static int waterR, waterC; // 처음 물이 차있는 곳 좌표
	static int goR, goC; // 처음 고슴도치 있는 곳 좌표

	private static char[][] map;
	private static boolean[][] visited;
	private static int[][] water;

	static int[] dirY = { -1, 1, 0, 0 };
	static int[] dirX = { 0, 0, -1, 1 };

	static Queue<int[]> waterQ = new LinkedList<int[]>();

	static int ans = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 1][C + 1];
		visited = new boolean[R][C];
		water = new int[R][C]; // 물이 차는 시간 기록

		// 입력
		for (int i = 0; i < R; i++) {
			String str = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '*') {
					waterQ.offer(new int[] { i, j, 0 });
				} else if (map[i][j] == 'S') {
					goR = i;
					goC = j;
				} else if (map[i][j] == 'D' || map[i][j] == 'X') {
					water[i][j] = -1;
				}
			}
		}

		// water 배열에 물이 차는 시간 기록
		if (!waterQ.isEmpty()) {
			waterBfs(waterR, waterC);
		}

		goBfs(goR, goC);

		if (ans == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);

	} // end of main

	private static void goBfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int tr = q.peek()[0];
			int tc = q.peek()[1];
			int time = q.peek()[2];
			q.poll();

			for (int i = 0; i < dirX.length; i++) {
				int nr = tr + dirY[i];
				int nc = tc + dirX[i];

				if (0 > nr || nr >= R || 0 > nc || nc >= C)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[nr][nc] == 'X') // 돌이면 갈 수 없음
					continue;
				if (water[nr][nc] != 0 && time + 1 >= water[nr][nc] && water[nr][nc] != -1)
					// 물이 차지 않은 곳, 물이 찰 예정이 아닌 곳, 물이 찰 수 없는 곳은 갈 수 있음
					continue;

				if (map[nr][nc] == 'D') {
					ans = time + 1;
					return;
				}

				q.offer(new int[] { nr, nc, time + 1 });
				visited[nr][nc] = true;

			}
		}

		return;
	}

	private static void waterBfs(int r, int c) {

		while (!waterQ.isEmpty()) {
			int tr = waterQ.peek()[0];
			int tc = waterQ.peek()[1];
			int time = waterQ.peek()[2];
			waterQ.poll();

			for (int i = 0; i < dirX.length; i++) {
				int nr = tr + dirY[i];
				int nc = tc + dirX[i];
				if (0 <= nr && nr < R && 0 <= nc && nc < C && water[nr][nc] == 0) {
					waterQ.offer(new int[] { nr, nc, time + 1 });
					water[nr][nc] = time + 1;
				}
			}
		}

		return;

	}

} // end of class
