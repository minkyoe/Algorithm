import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {

	private static int M;
	private static int N;
	private static int K;
	private static int[][] arr;
	private static ArrayList<Integer> safeCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 세로 
		N = Integer.parseInt(st.nextToken()); // 가로 
		K = Integer.parseInt(st.nextToken());
		arr = new int[M+1][N+1];
		safeCnt = new ArrayList<Integer>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int fromC = Integer.parseInt(st.nextToken());
			int fromR = Integer.parseInt(st.nextToken());
			int toC = Integer.parseInt(st.nextToken());
			int toR = Integer.parseInt(st.nextToken());
			fill(fromR+1, fromC+1, toR, toC);
		}
		
		for (int r = 1; r <= M; r++) {
			for (int c = 1; c <= N; c++) {
				if (arr[r][c] == 1) continue;
				int cnt = bfs(r, c);
				safeCnt.add(cnt);
			}
		}

		Collections.sort(safeCnt);
		StringBuilder sb = new StringBuilder();
		sb.append(safeCnt.size()).append("\n");
		
		for (int i = 0; i < safeCnt.size(); i++) {
			sb.append(safeCnt.get(i)).append(" ");
		}
		
		System.out.println(sb);
	} // end of main

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int bfs(int r, int c) {
		arr[r][c] = 1;
		Queue<int[]> q = new LinkedList<>();
		int cnt = 1;
		q.offer(new int[] {r, c});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr <= 0 || nr > M || nc <= 0 || nc > N) continue;
				if (arr[nr][nc] == 1) continue;
				
				arr[nr][nc] = 1;
				q.offer(new int[] {nr, nc});
				++cnt;
			}
		}
		
		return cnt;
	}

	private static void fill(int startR, int startC, int endR, int endC) {
		for (int r = startR; r <= endR; r++) {
			for (int c = startC; c <= endC; c++) {
				arr[r][c] = 1;
			}
		}
	}

} // end of class
