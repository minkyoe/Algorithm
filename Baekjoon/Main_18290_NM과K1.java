import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18290_NM과K1 {

	private static int N, M, K, ans;
	private static int[][] map;
	private static Pos[] selected;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos {
		int r;
		int c;
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		selected = new Pos[K];
		ans = Integer.MIN_VALUE;
		
		comb(0, 0, 0);
		System.out.println(ans);
	} // end of main

	private static void comb(int y, int x, int k) {
		if (y > N || x > M) return;
		if (k == K) {
			boolean flag = true;
			int sum = 0;
			
ex:			for (int i = 0; i < K; i++) {
				Pos now = selected[i];
				sum += map[now.r][now.c];
				for (int j = 0; j < K; j++) {
					if (i == j) continue;
					Pos other = selected[j];
					if ((Math.abs(now.r - other.r) == 1 && Math.abs(now.c - other.c) == 0)
						|| (Math.abs(now.r - other.r) == 0 && Math.abs(now.c - other.c) == 1)) {
						flag = false;
						break ex;
					}
				}
			}
			if (flag) ans = Math.max(ans, sum);
			return;
		}
		
		for (int i = y; i < N; i++) {
			for (int j = x; j < M; j++) {
				selected[k] = new Pos(i, j);
				if (j == M-1) comb(i+1, 0, k+1);
				else comb(i, j+1, k+1);
				
				if (j == M-1) {
					x = 0;
					break;
				}
			}
		}
		
	}

} // end of class
