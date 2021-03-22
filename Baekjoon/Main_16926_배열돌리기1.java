import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {

	private static int N;
	private static int M;
	private static int R;
	private static int rCnt;
	private static int cCnt;
	private static int[][] map;
	private static int[][] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = new int[N][M];
		rCnt = N; cCnt = M;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				ans[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < R; i++) {
			rotate();
			rCnt = N; cCnt = M;
			
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < M; j++) {
					map[k][j] = ans[k][j];
				}
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int j = 0; j < M; j++) {
				System.out.print(ans[k][j] + " ");
			}
			System.out.println();
		}
	} // end of main
	
	// 하 우 상 좌 
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	private static void rotate() {
		int or = 0; int oc = 0; // origin
		int sr = 0; // startR
		int sc = 0; // startC
		
		for (int s = 0; s < M / 2; s++) {
			or = s; oc = s;
			sr = s; sc = s;
			
			for (int i = 0; i < dr.length; i++) {
				while (true) {
					int nr = sr + dr[i];
					int nc = sc + dc[i];
					
					if (nr >= or + rCnt || nr < or || nc >= oc + cCnt || nc < oc) 
						break;
					
					ans[nr][nc] = map[sr][sc];
					sr = nr;
					sc = nc;
				}
			}
			
			rCnt -= 2;
			cCnt -= 2;
			if (rCnt <= 0 || cCnt <= 0) break;
		}
	}

} // end of class
