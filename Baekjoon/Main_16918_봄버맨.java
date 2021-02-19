import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {

	private static int R;
	private static int C;
	private static int N;
	private static char[][] map;
	private static Queue<int[]> q;
	private static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		map = new char[R][C];
		time = 1;
		
		// 입력
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'O') q.offer(new int[] {i,j});
			}
		}
		
		while (time++ < N) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'O') q.offer(new int[] {i,j});
					else map[i][j] = 'O';
				}
			}
			if (time == N) break;
			bfs();
		}
		
		// 정답 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		

	} // end of main

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs() {
		time++;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			map[tr][tc] = '.';
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C ) continue;
				map[nr][nc] = '.';
			}
		}
		
	}
 
} // end of class
