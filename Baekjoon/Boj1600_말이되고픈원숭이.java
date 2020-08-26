import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Boj_1600_말이되고픈원숭이 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] dirY = { -1, 1, 0, 0 };
	static int[] dirX = { 0, 0, -1, 1 };

	// 시계방향 + 상하좌우
//	static int[] hdirY = { -1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0};
//	static int[] hdirX = { -2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1 };

	static int[] hdirY = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] hdirX = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static int K, W, H; // 원숭이가 쓸 수 있는 능력 수 , 가로, 세로
	private static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];

		for (int i = 0; i < H; i++) {
			String str = bf.readLine();
			for (int j = 0, index = 0; j < W; j++, index += 2) {
				map[i][j] = str.charAt(index);
			}
		}

		int minCnt = -1;
		boolean[][][] visited = new boolean[K + 1][H][W];
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0, 0, 0)); // [h, w, 이동거리, 능력 사용 횟수]
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Point p = q.peek();
			int h = p.h;
			int w = p.w;
			int cnt = p.cnt;
			int usedAb = p.usedAb;
			q.poll();

			if (h == H - 1 && w == W - 1) {
				minCnt = cnt;
				break;
			}

			if (usedAb < K) {
				for (int i = 0; i < hdirY.length; i++) {
					int nh = h + hdirY[i];
					int nw = w + hdirX[i];

					if (nh < 0 || nh >= H || nw < 0 || nw >= W || visited[usedAb + 1][nh][nw] || map[nh][nw] != '0') continue;

					visited[usedAb + 1][nh][nw] = true;
					q.offer(new Point(nh, nw, cnt + 1, usedAb + 1));
				}

			}
			
			for (int i = 0; i < dirX.length; i++) {
				int nh = h + dirY[i];
				int nw = w + dirX[i];

				if (nh < 0 || nh >= H || nw < 0 || nw >= W || visited[usedAb][nh][nw] || map[nh][nw] != '0') continue;

				visited[usedAb][nh][nw] = true;
				q.offer(new Point(nh, nw, cnt + 1, usedAb));
			}

		}

		System.out.println(minCnt);

	} // end of main

	static class Point {
		int h;
		int w;
		int cnt;
		int usedAb;

		public Point(int h, int w, int cnt, int usedAb) {
			super();
			this.h = h;
			this.w = w;
			this.cnt = cnt;
			this.usedAb = usedAb;
		}
	}

} // end of class
