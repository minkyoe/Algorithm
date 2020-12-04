package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382_방향전환2 {
	
	//  (x + 1, y), (x - 1, y)로 이동하는 것은 가로 이동, (x, y + 1), (x , y - 1)로 이동하는 것은 세로 이동
	static int[] dy = {0, 1, 0, -1}; // 인덱스 0,2 : 가로이동 / 1,3: 세로이동
	static int[] dx = {1, 0, -1, 0};
	private static int ans;
	private static int x2;
	private static int y2;
	private static final int TMP = 100;
	private static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc ; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()); // 출발
			int y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken()); // 도착
			y2 = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			visited = new boolean[201][201][2];
			
			
			bfs(x1, y1, 0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ").append(ans);
			System.out.println(sb);
		} // end of tc
		

	} // end of main
	
	private static void bfs(int x, int y, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, 0, 0});
		q.offer(new int[] {x, y, 0, 1});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x1 = tmp[0];
			int y1 = tmp[1];
			int tCnt = tmp[2];
			int tDir = tmp[3];
			if (x1 == x2 && y1 == y2) {
				ans = ans > tCnt ? tCnt : ans;
				break;
			}
			
			if (x1+TMP < 0 || y1+TMP < 0 || x1+TMP > 200 || y1+TMP > 200) continue;
			if (tCnt >= ans) break;
			if (visited[x1+TMP][y1+TMP][tDir]) continue;
			visited[x1+TMP][y1+TMP][tDir] = true;
			
			if (tDir == 0) {
				q.offer(new int[] {x1+dx[0], y1+dy[0], tCnt+1, 1});
				q.offer(new int[] {x1+dx[2], y1+dy[2], tCnt+1, 1});
			} else {
				q.offer(new int[] {x1+dx[1], y1+dy[1], tCnt+1, 0});
				q.offer(new int[] {x1+dx[3], y1+dy[3], tCnt+1, 0});
				
			}
		}
		return;
	}

} // end of class
