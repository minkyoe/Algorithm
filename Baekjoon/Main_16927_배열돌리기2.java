import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16927_배열돌리기2 {

	private static int N, M, R, rotateCnt, n, m;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotateCnt = Math.min(N, M) / 2; // 회전 횟수
		n = N; m = M;
		for (int j = 0; j < rotateCnt; j++) {
			int r = R % (2*n + 2*m - 4);
			rotate(j, j, r); // 시작점
			n -= 2; m -= 2;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	} // end of main

	// 우 하 좌 상 (시계방향) , 문제에서는 시계 반대 방향 
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	private static void rotate(int r, int c, int cnt) {
		int sr = r; int sc = c;
		int tmp = map[r][c];
		int nr = 0;
		int nc = 0;
		
		for (int i = 0; i < cnt; i++) {
			for (int dir = 0; dir < dc.length; dir++) {
				while (true) {
					nr = r + dr[dir];
					nc = c + dc[dir];
					
					if (nr < sr || nr >= sr + n || nc < sc || nc >= sc + m) {
						break;
					}
					map[r][c] = map[nr][nc];
					r = nr; c = nc;
				}
			}
			map[r+1][c] = tmp;
			r = sr; c = sc;
			tmp = map[r][c];
		}
		
	}
	

} // end of class
