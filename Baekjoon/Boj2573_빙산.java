import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M; // 행, 열
	private static int[][] map;
	static int[] dirY = { -1, 1, 0, 0 };
	static int[] dirX = { 0, 0, -1, 1 };
	private static Queue<Point> bQ;
	private static Queue<Point> dQ;
	static int ans = 0;
	private static boolean[][] visited;
	private static int[][] mapOrigin;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapOrigin = new int[N][M];
		visited = new boolean[N][M]; // 덩어리 확인할때 쓰일 배열

		bQ = new LinkedList<Point>(); // 빙산 좌표 넣는 큐.
		dQ = new LinkedList<Point>(); // 덩어리 개수 확인을 위한 빙산 좌표 넣는 큐.

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapOrigin[i][j] = map[i][j]; // map Copy해둠
				if (map[i][j] > 0)
					bQ.offer(new Point(i, j));
			}
		}

		while (true) { // 두 덩어리 이상으로 분리되면 break
			// 빙산 녹음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapOrigin[i][j] > 0) {
						int meltCnt = 0;
						for (int k = 0; k < dirY.length; k++) {
							int nr = i + dirY[k];
							int nc = j + dirX[k];

							if (0 <= nr && nr < N && 0 <= nc && nc < M) {
								if (mapOrigin[nr][nc] == 0) {
									meltCnt++;
								}
							}
						} // end of dir for

						int after = mapOrigin[i][j] - meltCnt;
						if (after < 0)
							map[i][j] = 0;
						else
							map[i][j] = after;
					}
				}
			}
			ans++; // 1년 지남

			// map -> mapOrigin copy
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, mapOrigin[i], 0, M);
			}

			// 빙산 덩어리 개수 구하기
			int dung = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0) {
						if (!visited[i][j]) {
							visited[i][j] = true;
							bfs2(i, j);
							dung++;
						}
					}
				}
			}

			if (dung >= 2) {
				break;
			}
			if (dung == 0) {
				ans = 0;
				break;
			}

			// visited 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}

		} // end of while

		System.out.println(ans);

	} // end of main

	/** 덩어리 개수 확인하는 메서드 */
	private static void bfs2(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(y, x));

		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.peek().c;
			q.poll();

			for (int i = 0; i < dirY.length; i++) {
				int nr = r + dirY[i];
				int nc = c + dirX[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] > 0) {
					if (!visited[nr][nc]) {
						q.offer(new Point(nr, nc));
						visited[nr][nc] = true;
					}
				}
			} // end of dir for
		}

		return;
	}

}

class Point {
	int r;
	int c;

	public Point() {
	}

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + "]";
	}

}