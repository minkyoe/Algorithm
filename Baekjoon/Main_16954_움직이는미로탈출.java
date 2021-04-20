import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16954_움직이는미로탈출 {

	// 좌상부터 9 방향 (+제자리에 서있는 경우)
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {0, -1, 0, 1, 1, 1, 0, -1, -1};
	private static char[][][] map;
	private static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new char[9][8][8];
		visited = new boolean[9][8][8];
		int ans = 0;
		
		for (int i = 0; i < 8; i++) {
			String s = bf.readLine();
			for (int j = 0; j < 8; j++) {
				map[0][i][j] = s.charAt(j);
			}
		}
		
		for (int k = 1; k <= 8; k++) { // 시간
			for (int i = 7; i > 0; i--) { // 행 
				for (int j = 0; j < 8; j++) { // 열 
					map[k][i][j] = map[k-1][i-1][j];
				}
				for (int j = 0; j < 8; j++) {
					map[k][0][j] = '.';
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		visited[0][7][0] = true;
		q.offer(new int[] {7, 0, 0});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			if (tr == 0 && tc == 7) {
				ans = 1;
				break;
			}
			
			for (int i = 0; i < dc.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (cnt+1 == 9) {
					ans = 1;
					break;
				}
				if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8 || visited[cnt+1][nr][nc]) continue;
				if (map[cnt][nr][nc] == '#' || map[cnt+1][nr][nc] == '#') continue;
				visited[cnt+1][nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
			
		}

		System.out.println(ans);
	} // end of main

} // end of class
