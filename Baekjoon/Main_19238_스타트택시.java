import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_스타트택시 {

	private static int N, M, OIL;
	private static int taxiR, taxiC; // 택시 출발점
	private static int[][] map;
	private static boolean[] isArrived;
	private static int[][] guest;
	private static PriorityQueue<Guest> guests;
	private static class Guest implements Comparable<Guest>{
		int idx;
		int r;
		int c;
		int dist;
		
		Guest(int idx, int r, int c, int dist) {
			this.idx = idx;
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		public int compareTo(Guest o) {
			if (this.dist == o.dist) {
				if (this.r == o.r) {
					return this.c - o.c;
				}
				return this.r - o.r;
			}
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		OIL = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		isArrived = new boolean[M]; // 승객 데려다줬는지
		guest = new int[M][4]; // 승객 정보
		
		for (int i = 1; i <= N; i++) {
			String s = bf.readLine();
			for (int j = 1, index = 0; j <= N; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
			}
		}
		st = new StringTokenizer(bf.readLine(), " ");
		taxiR = Integer.parseInt(st.nextToken());
		taxiC = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			guest[i][0] = Integer.parseInt(st.nextToken());
			guest[i][1] = Integer.parseInt(st.nextToken());
			guest[i][2] = Integer.parseInt(st.nextToken());
			guest[i][3] = Integer.parseInt(st.nextToken());
		}
		int completed = 0; // 데려다 준 승객 수
		while (completed < M) {
			guests = new PriorityQueue<>();
			getDistToGuests(taxiR, taxiC);
			
			if (guests.isEmpty()) {
				OIL = -1;
				break;
			}
			
			Guest close = guests.poll();
			int toDest = getDistToDest(close.r, close.c, guest[close.idx][2], guest[close.idx][3]);
			// 도착지 까지 길이 없음 || 도착지 까지 가는 과정에 연료가 바닥남 
			if (toDest == -1 || OIL - close.dist - toDest < 0) {
				OIL = -1;
				break;
			}
			
			// 도착지로 택시 이동
			taxiR = guest[close.idx][2];
			taxiC = guest[close.idx][3];
			// 연료에서 값 빼고 충전
			OIL = OIL - (close.dist + toDest) + (toDest * 2);
			// 완료 승객 처리
			++completed;
			isArrived[close.idx] = true;
			
			if (OIL < 0) {
				OIL = -1;
				break;
			}
		}
		
		System.out.println(OIL);

	} // end of main

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int getDistToDest(int startR, int startC, int endR, int endC) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][N+1];
		q.offer(new int[] {startR, startC, 0});
		visited[startR][startC] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			if (tr == endR && tc == endC) {
				return cnt;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
				if (visited[nr][nc] || map[nr][nc] == 1) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		return -1;
	}
	
	private static int getDistToGuests(int startR, int startC) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] bfsVisited = new boolean[N+1][N+1];
		q.offer(new int[] {startR, startC, 0});
		bfsVisited[startR][startC] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			for (int i = 0; i < M; i ++) {
				if (!isArrived[i] && tr == guest[i][0] && tc == guest[i][1]) {
					guests.offer(new Guest(i, guest[i][0], guest[i][1], cnt));
				}
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
				if (bfsVisited[nr][nc] || map[nr][nc] == 1) continue;
				bfsVisited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		return -1;
	}
 
} // end of class
