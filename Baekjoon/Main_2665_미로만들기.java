import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2665_미로만들기 {

	private static int N;
	private static int[][] map;
	private static int[][] count;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		count = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
				count[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,0}); // r, c, 만난 검정 수
		count[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			if (tr == N-1 && tc == N-1) {
				count[tr][tc] = Math.min(count[tr][tc], cnt);
				continue;
			}
			
			for (int i = 0; i < dc.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				// 방문한적 있다면
				if (count[nr][nc] != Integer.MAX_VALUE) {
					if (map[nr][nc] == 0) { // 검은색이라면
						if (cnt+1 < count[nr][nc]) {
							q.offer(new int[] {nr, nc, cnt+1});
							count[nr][nc] = cnt+1; 
						} 
					}
					else { // 흰색이라면
						if (cnt < count[nr][nc]) {
							q.offer(new int[] {nr, nc, cnt});
							count[nr][nc] = cnt;
						}
					}
				}
				// 방문한적 없다면
				else {
					if (map[nr][nc] == 0) { // 검은색이라면
						count[nr][nc] = cnt + 1;
						q.offer(new int[] {nr, nc, cnt + 1});
					} else { // 흰색이라면
						count[nr][nc] = cnt;
						q.offer(new int[] {nr, nc, cnt});
					}
				}
			}
		}
		
		System.out.println(count[N-1][N-1]);
	} // end of main

} // end of class
