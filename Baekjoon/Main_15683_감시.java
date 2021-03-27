import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	private static int N, M, empty, ans;
	private static int[][] map;
	private static int[] selected;
	private static ArrayList<CCTV> list = new ArrayList<>();
	// 우 하 좌 상 
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static class CCTV {
		int r;
		int c;
		int idx; // cctv 번호
		int[][] dir;
		
		CCTV (int r, int c, int idx) {
			this.r = r;
			this.c = c;
			this.idx = idx;
			
			if (idx == 1) { 
				dir = new int[4][1]; // 한방향 네가지 
				dir[0][0] = 0; dir[1][0] = 1; dir[2][0] = 2; dir[3][0] = 3;
			}
			else if (idx == 2) {
				dir = new int[2][2]; // 두방향 두가지
				dir[0][0] = 0; dir[0][1] = 2;
				dir[1][0] = 1; dir[1][1] = 3;
			}
			else if (idx == 3) {
				dir = new int[4][2]; // 두방향 네가지
				dir[0][0] = 3; dir[0][1] = 0;
				dir[1][0] = 0; dir[1][1] = 1;
				dir[2][0] = 2; dir[2][1] = 1;
				dir[3][0] = 3; dir[3][1] = 2;
			}
			else if (idx == 4) {
				dir = new int[4][3]; // 세방향 네가지 
				dir[0][0] = 3; dir[0][1] = 2; dir[0][2] = 0;
				dir[1][0] = 3; dir[1][1] = 0; dir[1][2] = 1;
				dir[2][0] = 2; dir[2][1] = 0; dir[2][2] = 1;
				dir[3][0] = 3; dir[3][1] = 2; dir[3][2] = 1;
			}
			else if (idx == 5) {
				dir = new int[1][4]; // 네방향 한가지
				dir[0][0] = 0; dir[0][1] = 1; dir[0][2] = 2; dir[0][3] = 3;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 0) ++empty;
				else if (1<= map[i][j] && map[i][j] <= 5) {
					list.add(new CCTV (i, j, map[i][j]));
				}
			}
		}
		
		selected = new int[list.size()];
		dfs(0, 0);
		
		System.out.println(ans);

	} // end of main

	private static void dfs(int idx, int cnt) {
		if (cnt == list.size()) {
			detect();
			return;
		}
		
		for (int i = 0; i < list.get(idx).dir.length; i++) {
			selected[cnt] = i;
			dfs(idx+1, cnt+1);
		}
	}

	private static void detect() {
		int[][] copy = new int[N][M];
		int tmpEmpty = empty;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < selected.length; i++) {
			int idx = i;
			int order = selected[i];
			
			for (int j = 0; j < list.get(idx).dir[order].length; j++) {
				int dir = list.get(idx).dir[order][j];
				int r = list.get(idx).r;
				int c = list.get(idx).c;
				
				while(true) {
					r += dr[dir];
					c += dc[dir];
					
					if (r < 0 || r >= N || c < 0 || c >= M) break;
					if (copy[r][c] == 6) break;
					if ((1 <= copy[r][c] && copy[r][c] <= 5) || copy[r][c] == 7) continue;
					copy[r][c] = 7;
					--tmpEmpty;
				} // end of while
 			}
		}
		
		ans = Math.min(ans, tmpEmpty);
	}

} // end of class
